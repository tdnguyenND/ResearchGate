package com.example.ResearchGate.controller;

import com.example.ResearchGate.model.Review;
import com.example.ResearchGate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/review/{companyId}")
    public void postReview(@RequestParam("content") String content,
                           @PathVariable String companyId,
                           @CookieValue("userId") String studentId){
        Review review = new Review();
        review.content = content;
        review.studentId = Integer.parseInt(studentId);
        review.companyId = Integer.parseInt(companyId);

        reviewService.save(review);
    }
}
