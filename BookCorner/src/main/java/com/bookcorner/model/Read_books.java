package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
//@Entity
public class Read_books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Book> books;

    private String personal_comment;

    @OneToMany
    private List<Quotes> favorite_quotes;


    public Read_books() {
    }
}

