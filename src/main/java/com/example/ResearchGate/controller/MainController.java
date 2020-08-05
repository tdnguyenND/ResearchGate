package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    AccountService accountService;

    @GetMapping("/home")
    public String getHome(@CookieValue String role, Model model){
        model.addAttribute("role", role);
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
    public String registerAsStudent(){
        return "studentRegister";
    }

    @GetMapping("/companyRegister")
    public String registerAsCompany(){
        return "companyRegister";
    }
}
