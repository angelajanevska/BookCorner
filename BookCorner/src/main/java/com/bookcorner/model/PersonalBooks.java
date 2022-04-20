package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class PersonalBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //???? call, ili id da zema od api isbn
    private String ISBN;

    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    private User user;

    private Integer current_page;

    @OneToMany
    private List<Quotes> favorite_quotes;

    public PersonalBooks() {

    }

    public PersonalBooks(String isbn, BookStatus status, User user, Integer current_page, List<Quotes> favorite_quotes) {
        this.ISBN = isbn;
        this.status = status;
        this.user = user;
        this.current_page = current_page;
        this.favorite_quotes = favorite_quotes;
    }
}
