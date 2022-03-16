package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Currently_reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Book> books;

    private Integer current_page;

    private Integer pages;

    @OneToMany
    private List<Quotes> favorite_quotes;


    public Currently_reading() {

    }
}
