package com.example.ResearchGate.controller;

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
        String[] listOfPL = request.getParameter("programmingLanguage").split(",");
        for (int i = 0; i < listOfPL.length; i++){
            listOfPL[i] = listOfPL[i].trim();
        }
        return new HashSet<>(Arrays.asList(listOfPL));
    }
}
