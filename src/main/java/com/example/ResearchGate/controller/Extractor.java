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

    public static Object extractCookie(HttpServletRequest request, String cookieName) throws Exception{
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            if (cookie.getName().equals(cookieName)) return cookie.getValue();
        }
        throw new Exception();
    }

    public static HashSet<String> extractProgrammingLanguages(HttpServletRequest request) throws Exception{
        if (request.getParameter("programmingLanguage") == null) return null;
        String[] listOfPL = request.getParameter("programmingLanguage").split(",");
        for (int i = 0; i < listOfPL.length; i++){
            listOfPL[i] = listOfPL[i].trim();
        }
        return new HashSet<>(Arrays.asList(listOfPL));
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
