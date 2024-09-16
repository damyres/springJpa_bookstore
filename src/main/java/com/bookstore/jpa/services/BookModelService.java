package com.bookstore.jpa.services;

import com.bookstore.jpa.dtos.BookRecordDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.models.ReviewModel;
import com.bookstore.jpa.repositories.AuthorRepository;
import com.bookstore.jpa.repositories.BookModelRepository;
import com.bookstore.jpa.repositories.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookModelService {
    private final BookModelRepository bookModelRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BookModelService(final BookModelRepository bookModelRepository,
                            final AuthorRepository authorRepository,
                            final PublisherRepository publisherRepository) {
        this.bookModelRepository = bookModelRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    public List<BookModel> getAllBooks() {
        return bookModelRepository.findAll();
    }

    @Transactional //garante um rollback
    public BookModel save(final BookRecordDto bookRecordDto) {
        BookModel book = new BookModel();
        book.setTitle(bookRecordDto.title());
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComments());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookModelRepository.save(book);
    }

    @Transactional
    public void delete(UUID id){
        bookModelRepository.deleteById(id);
    }
}