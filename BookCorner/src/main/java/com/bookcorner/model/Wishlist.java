package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
//@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Book> books;

    public Wishlist() {
    }
}
