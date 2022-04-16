package com.bookcorner.service.implementation;

import com.bookcorner.model.Book;
import com.bookcorner.repository.BookRepository;
import com.bookcorner.service.BookService;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(String title, String author, String isbn, String release_date, String pages) {
        this.bookRepository.save(new Book(title,author,isbn,release_date,pages));
    }

    @Override
    public void saveBookInit(String title, String author, String isbn, String release_date, String pages) throws IOException, CsvValidationException {
    }


}
