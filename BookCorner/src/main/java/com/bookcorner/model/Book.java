package com.bookcorner.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String release_date;
    private String pages;
    private String coverURL;

    public Book(String title, String author, String isbn, String release_date, String pages, String coverURL) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.release_date = release_date;
        this.pages = pages;
        this.coverURL = coverURL;
    }

    public Book() {
    }
}
