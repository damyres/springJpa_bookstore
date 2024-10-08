package com.bookstore.jpa.services;

import com.bookstore.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(final AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

}
