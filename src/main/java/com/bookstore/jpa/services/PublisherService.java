package com.bookstore.jpa.services;

import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository repository;

    @Autowired
    public PublisherService(final PublisherRepository repository){
        this.repository = repository;
    }
}
