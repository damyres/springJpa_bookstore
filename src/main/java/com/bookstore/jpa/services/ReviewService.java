package com.bookstore.jpa.services;

import com.bookstore.jpa.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService (ReviewRepository repository){
        this.repository = repository;
    }


}
