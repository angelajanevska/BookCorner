package com.bookcorner.service.implementation;

import com.bookcorner.model.Book;
import com.bookcorner.repository.BookRepository;
import com.bookcorner.service.BookService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(String title, String author, String isbn, String release_date, String pages, String coverURL) {
        Book book = new Book(title,author,isbn,release_date,pages,coverURL);
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

}
