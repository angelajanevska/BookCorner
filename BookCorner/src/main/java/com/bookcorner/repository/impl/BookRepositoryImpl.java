package com.bookcorner.repository.impl;

import com.bookcorner.model.Book;
import com.bookcorner.repository.BookRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class BookRepositoryImpl  {
    private final BookRepository bookRepository ;

    public BookRepositoryImpl(BookRepository bookRepository) throws IOException {
        this.bookRepository = bookRepository;
    }
    
    public void save(String title, String author, String release_date, Integer pages){
        this.bookRepository.save(new Book(title, author, release_date, pages));
    }
}
