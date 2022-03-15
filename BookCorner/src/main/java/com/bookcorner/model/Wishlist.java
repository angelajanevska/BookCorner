package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Book book_id;
}
