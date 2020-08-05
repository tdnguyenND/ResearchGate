package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Account;
import com.example.ResearchGate.model.ProgrammingLanguage;
import com.example.ResearchGate.model.Student;
import com.example.ResearchGate.service.AccountService;
import com.example.ResearchGate.service.ProgrammingLanguageService;
import com.example.ResearchGate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Controller()
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    AccountService accountService;

    @Autowired
    ProgrammingLanguageService programmingLanguageService;

    @GetMapping("/student/updateInfo")
    public String updateInfo(@CookieValue("userId")Integer userId, Model model){
        model.addAttribute("student", studentService.findByUserId(userId).get());
        return "studentInfo";
    }

    @PostMapping("/student/updateInfo")
    public void doUpdateInfo(@CookieValue("userId") Integer userId,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        Student student = Extractor.extractStudent(request);

        studentService.updateInformation(student);

        saveProgrammingLanguage(request, userId);

        response.getWriter().write("successful");
    }

    @PostMapping("/student/register")
    public void registerAsStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        if (accountService.findAccountByUsername(username).isPresent()){
            response.getWriter().println("username existed!");
        }else {
            Account account = new Account();
            account.username = username;
            account.password = request.getParameter("password");
            account.role = "student";
            account = accountService.save(account);

            //save student
            Student student = Extractor.extractStudent(request);
            student.userId = account.userId;
            saveProgrammingLanguage(request, student.userId);

            studentService.save(student);
            response.sendRedirect("../login");
        }
    }

    private void saveProgrammingLanguage(HttpServletRequest request, Integer userId) throws Exception {
        programmingLanguageService.deleteAllByUserId(userId);
        Set<String> set =Extractor.extractProgrammingLanguages(request);
        if (set == null || set.isEmpty()) return;
        set.forEach((String programmingLanguage) ->{
            ProgrammingLanguage pl = new ProgrammingLanguage();
            pl.userId = userId;
            pl.programmingLanguage = programmingLanguage;
            programmingLanguageService.save(pl);
        });
    }
}
