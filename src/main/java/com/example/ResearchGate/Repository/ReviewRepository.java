package com.example.ResearchGate.Repository;

import com.example.ResearchGate.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
    Iterable<Review> findAllByCompanyId(Integer companyId);
}
