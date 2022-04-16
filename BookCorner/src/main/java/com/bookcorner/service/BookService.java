package com.bookcorner.service;

import com.bookcorner.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    void save(String title, String author, String isbn, String release_date, String pages, String coverURL);
    List<Book> listBooks();
}
