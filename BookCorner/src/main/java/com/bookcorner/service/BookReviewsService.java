package com.bookcorner.service;

import com.bookcorner.model.BookReviews;

import java.util.List;
import java.util.Optional;

public interface BookReviewsService {
    void save(String ISBN);

    List<BookReviews> findAll();

    Optional<BookReviews> findById(Long id);

    void addReviewToBook(String ISBN, Integer rating);
//    Optional<Book> findByISBN(String title);
}
