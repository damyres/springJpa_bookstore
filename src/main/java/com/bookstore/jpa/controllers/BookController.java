package com.bookstore.jpa.controllers;

import com.bookstore.jpa.services.BookModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookModelService bookModelService;

    @Autowired
    public BookController(final BookModelService bookModelService){
        this.bookModelService = bookModelService;
    }

}
