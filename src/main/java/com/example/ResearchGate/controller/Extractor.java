package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Company;
import com.example.ResearchGate.model.Student;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;

public class Extractor {
    public static Student extractStudent(HttpServletRequest request) {
        Student student = new Student();
        student.firstName = request.getParameter("firstName");
        student.lastName = request.getParameter("lastName");
        student.address = request.getParameter("address");
        student.dateOfBirth = request.getParameter("dateOfBirth");
        student.gender = request.getParameter("gender");
        student.phoneNumber = request.getParameter("phoneNumber");
        student.email = request.getParameter("email");
        student.academicLevel = request.getParameter("academicLevel");
        student.trainingPlace = request.getParameter("trainingPlace");
        student.achievement = request.getParameter("achievement");
        student.forte = request.getParameter("forte");
        student.hobbits = request.getParameter("hobbits");

        return student;
    }

    public static String extractCookie(HttpServletRequest request, String cookieName) throws Exception{
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals(cookieName)) return cookie.getValue();
        }
        throw new Exception();
    }

    public static String[] extractProgrammingLanguages(HttpServletRequest request) throws Exception{
        return request.getParameterValues("language");
    }

    public static Company extractCompany(HttpServletRequest request) {
        Company company = new Company();
        company.address = request.getParameter("address");
        company.hotlines = request.getParameter("hotlines");
        company.email = request.getParameter("email");
        company.nameCompany = request.getParameter("name_company");

        return company;
    }
}
