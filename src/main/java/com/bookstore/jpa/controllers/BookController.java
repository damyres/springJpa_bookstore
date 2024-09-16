package com.bookstore.jpa.controllers;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.services.BookModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookModelService bookModelService;

    @Autowired
    public BookController(final BookModelService bookModelService) {
        this.bookModelService = bookModelService;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookModelService.getAllBooks());

    }

    @PostMapping
    public ResponseEntity<BookModel> save(@RequestBody BookRecordDto bookRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookModelService.save(bookRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        bookModelService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted sucessfully.");
    }
}
