package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.model.Company;
import com.example.ResearchGate.service.AccountService;
import com.example.ResearchGate.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller()
public class CompanyController {
    @Autowired
    AccountService accountService;

    @Autowired
    CompanyService companyService;

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
}
