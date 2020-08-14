package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.model.Company;
import com.example.ResearchGate.model.Review;
import com.example.ResearchGate.service.AccountService;
import com.example.ResearchGate.service.CompanyService;
import com.example.ResearchGate.service.ReviewService;
import com.example.ResearchGate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller()
public class CompanyController {
    @Autowired
    AccountService accountService;

    @Autowired
    CompanyService companyService;
    @Autowired
    ReviewService reviewService;
    @Autowired
    StudentService studentService;

    @GetMapping("/company/updateInfo")
    public String updateInfo(@CookieValue("userId") Integer userId, Model model){
        model.addAttribute("company", companyService.findById(userId).get());
        return "companyInfo";
    }

    @PostMapping("/company/updateInfo")
    public void doUpdateInfo(@CookieValue("userId") Integer userId,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        Company company = Extractor.extractCompany(request);
        company.userId = userId;
        companyService.updateInfo(company);

        response.getWriter().write("success");
    }

    @PostMapping("/company/register")
    public void registerAsCompany(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        if (accountService.findAccountByUsername(username).isPresent()){
            response.getWriter().println("username existed!");
        }else {
            Account account = new Account();
            account.username = username;
            account.password = request.getParameter("password");
            account.role = "company";
            account = accountService.save(account);

            //save student
            Company company = Extractor.extractCompany(request);
            company.userId = account.userId;

            companyService.save(company);
            response.sendRedirect("../login");
        }
    }

    @GetMapping("/company/publicInfo/{userId}")
    public String getCompanyPublicInfo(@PathVariable String userId,
                                     Model model){
        model.addAttribute("company", companyService.findById(Integer.parseInt(userId)).get());
        List<Map<String, Object>> reviews = new ArrayList<>();
        for (Review review: reviewService.findAllByCompanyId(Integer.parseInt(userId))) {
            Map<String, Object> reviewContainer = new HashMap<>();
            reviewContainer.put("content", review.content);
            reviewContainer.put("student", studentService.findByUserId(review.studentId).get());
            reviews.add(reviewContainer);
        }
        model.addAttribute("reviews", reviews);
        return "companyPublicInfo";
    }
}
