package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String getHome(){
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
            response.sendRedirect("/home");
        }else {
            response.getWriter().println("username and password not match");
        }
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
