package com.bookstore.jpa.services;

import com.bookstore.jpa.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(final PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }
}
