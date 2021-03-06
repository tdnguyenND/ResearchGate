package com.example.ResearchGate.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ResearchGate.service.ProgrammingLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ResearchGate.model.Recruitment;
import com.example.ResearchGate.service.RecruitmentService;

@Controller()
public class RecruitmentController {
	
	@Autowired
	RecruitmentService recruitmentService;
	@Autowired
	ProgrammingLanguageService programmingLanguageService;
	
	@PostMapping("/recruitment")
	public void recruitmentPosting(@CookieValue("userId") Integer userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Recruitment recruitment = new Recruitment();
		recruitment.userId = userId;
		recruitment.career = request.getParameter("career");
		String amount = request.getParameter("amount");
		recruitment.amount = Integer.parseInt(amount);
		recruitment.salary = request.getParameter("salary");
		recruitment.language = request.getParameter("language");
		recruitment.requirement = request.getParameter("requirement");
		recruitment.advantage = request.getParameter("advantage");
		recruitment.typeOfWork = request.getParameter("type_of_work");
		
		recruitmentService.save(recruitment);
		response.sendRedirect("../recruitment");
	}

	@GetMapping("/recruitment")
	public String recruit(Model model){
		model.addAttribute("listProgrammingLanguage", programmingLanguageService.findAllProgrammingLanguage());
		return "recruitment";
	}
}
