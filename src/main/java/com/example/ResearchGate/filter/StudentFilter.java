package com.example.ResearchGate.filter;

import com.example.ResearchGate.controller.Extractor;
import com.example.ResearchGate.model.Student;
import com.example.ResearchGate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class StudentFilter implements Filter {
    @Autowired
    StudentService studentService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        try{
            if (studentService.findByUserId((Integer) Extractor.extractCookie(request, "userId")).isPresent()){
                filterChain.doFilter(request, response);
            }else{
                response.getWriter().write("You don't have permission to do this!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
