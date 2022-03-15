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
    private LocalDate release_date;
    private Integer pages;
}
