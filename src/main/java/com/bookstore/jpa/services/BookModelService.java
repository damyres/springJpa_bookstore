package com.bookstore.jpa.services;

import com.bookstore.jpa.repositories.BookModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookModelService {
    private final BookModelRepository repository;

    @Autowired
    public BookModelService(final BookModelRepository repository) {
        this.repository = repository;
    }
}