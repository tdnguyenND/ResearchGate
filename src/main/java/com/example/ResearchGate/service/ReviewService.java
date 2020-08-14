package com.example.ResearchGate.service;

import com.example.ResearchGate.model.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    Iterable<Review> findAllByCompanyId(Integer companyId);

    Review save(Review review);
}
