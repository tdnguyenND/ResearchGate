package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Application;
import com.example.ResearchGate.model.Student;
import com.example.ResearchGate.service.ApplicationService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;
    @Autowired
    StudentService studentService;

    @GetMapping("/application/{recruitmentId}")
    public String getAllAppsOfRecruitment(@PathVariable String recruitmentId,
                                          Model model){
        List<Map<String, Object>> appDetails = new ArrayList<>();
        for (Application app: applicationService.findAllByRecruitmentId(Integer.parseInt(recruitmentId))){
            Map<String, Object> detail = new HashMap<>();
            detail.put("student", studentService.findByUserId(app.studentId).get());
            detail.put("app", app);
            appDetails.add(detail);
        }
        model.addAttribute("appDetails", appDetails);
        return "appDetails";
    }
    @PostMapping("/application/apply/{recruitmentId}")
    public void apply(@CookieValue("userId")Integer studentId,
                      @PathVariable Integer recruitmentId,
                      HttpServletRequest request){
        Application app = Extractor.extractApplication(request);
        app.studentId = studentId;
        app.recruitmentId = recruitmentId;

        applicationService.save(app);
    }
}
