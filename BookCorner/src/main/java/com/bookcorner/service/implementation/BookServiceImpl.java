package com.bookcorner.service.implementation;

import com.bookcorner.model.Book;
import com.bookcorner.repository.BookRepository;
import com.bookcorner.service.BookService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(String title, String author, String isbn, String release_date, String pages, String coverURL) {
        this.bookRepository.save(new Book(title,author,isbn,release_date,pages,coverURL));
    }

    @Override
    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }


}
