package com.bookcorner.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    private Long isbn;
    private String title;
    private String author;
    private String release_date;
    private Integer pages;

    public Book(String title, String author, String release_date, Integer pages) {
        this.title = title;
        this.author = author;
        this.release_date = release_date;
        this.pages = pages;
    }

    public Book() {
    }
}
