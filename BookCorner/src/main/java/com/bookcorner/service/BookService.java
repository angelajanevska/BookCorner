package com.bookcorner.service;

import com.bookcorner.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    void save(String title, String author, String isbn, String release_date, String pages, String coverURL);
    List<Book> findAll();


    Optional<Book> findById(Long id);

    Optional<Book> findByTitle(String title);


}
