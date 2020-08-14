package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.*;
import com.example.ResearchGate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    AccountService accountService;

    @Autowired
    ProgrammingLanguageService programmingLanguageService;

    @Autowired
    RecruitmentService recruitmentService;

    @Autowired
    CompanyService companyService;
    @Autowired
    ApplicationService applicationService;

    @GetMapping("/home")
    public String getHome(@CookieValue Integer userId,
                          @CookieValue String role,
                          Model model){
        model.addAttribute("role", role);
        model.addAttribute("listProgrammingLanguage", programmingLanguageService.findAllProgrammingLanguage());
        List<Integer> applied = new ArrayList<>();
        for (Application apps : applicationService.findAllByStudentId(userId)){
            applied.add(apps.recruitmentId);
        }
        model.addAttribute("applied", applied);
        if (role.equals("student")) {
            List<HashMap<String, Object>> listRecruitment = new ArrayList<>();
            for(Recruitment recruitment: recruitmentService.findAll()){
                HashMap<String, Object> recruitmentDetail = new HashMap<>();
                recruitmentDetail.put("detail", recruitment);
                recruitmentDetail.put("companyName", companyService.findById(recruitment.userId).get().nameCompany);
                listRecruitment.add(recruitmentDetail);
            }
            model.addAttribute("listRecruitment", listRecruitment);
        }else if (role.equals("company")) {
            model.addAttribute("listRecruitment", recruitmentService.findAllByUserId(userId));
        }
        return "home";
    }
    @PostMapping("/home")
    public String getHomeWithSpecificLanguage(@CookieValue Integer userId,
                                              @RequestParam("language")String language,
                                              @CookieValue String role,
                                              Model model){
        if (language.equals("All")) return getHome(userId, role, model);
        model.addAttribute("role", role);
        model.addAttribute("listProgrammingLanguage", programmingLanguageService.findAllProgrammingLanguage());
        if (role.equals("student")) {
            List<HashMap<String, Object>> listRecruitment = new ArrayList<>();
            for(Recruitment recruitment: recruitmentService.findByLanguage(language)){
                HashMap<String, Object> recruitmentDetail = new HashMap<>();
                recruitmentDetail.put("detail", recruitment);
                recruitmentDetail.put("companyName", companyService.findById(recruitment.userId).get().nameCompany);
                listRecruitment.add(recruitmentDetail);
            }
            model.addAttribute("listRecruitment", listRecruitment);
        }else if (role.equals("company")) {
            model.addAttribute("listRecruitment", recruitmentService.findAllByUserId(userId));
        }
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountService.findAccountByUsername(username).get();
        if (account.password.equals(password)){
            response.addCookie(new Cookie("userId", account.userId.toString()));
            response.addCookie(new Cookie("role", account.role));
            response.sendRedirect("/home");
        }else {
            response.getWriter().println("username and password not match");
        }
    }
    @GetMapping("/studentRegister")
    public String registerAsStudent(Model model){
        model.addAttribute("listProgrammingLanguage", programmingLanguageService.findAllProgrammingLanguage());
        return "studentRegister";
    }

    @GetMapping("/companyRegister")
    public String registerAsCompany(){
        return "companyRegister";
    }
}
