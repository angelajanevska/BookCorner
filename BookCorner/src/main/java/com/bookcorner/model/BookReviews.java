package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class BookReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISBN;

    @ManyToMany
    private List<Rating> reviews;

    public BookReviews(String ISBN) {
        this.ISBN = ISBN;
        this.reviews = new ArrayList<>();
    }

    public BookReviews() {

    }
}
