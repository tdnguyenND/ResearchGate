package com.example.ResearchGate.service.impl;

import com.example.ResearchGate.Repository.ReviewRepository;
import com.example.ResearchGate.model.Review;
import com.example.ResearchGate.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository repository;
    @Override
    public Iterable<Review> findAllByCompanyId(Integer companyId) {
        return repository.findAllByCompanyId(companyId);
    }

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }
}
