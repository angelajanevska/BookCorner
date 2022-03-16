package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String sex;
    private LocalDate birthday;

    @OneToOne
    private Wishlist wishlist;

    @OneToOne
    private Currently_reading currently_reading;

    @OneToOne
    private Read_books read_books_id;

    public User(String name, String surname, String username, String email, String sex, LocalDate birthday, Wishlist wishlist, Currently_reading currently_reading, Read_books read_books_id) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.wishlist = wishlist;
        this.currently_reading = currently_reading;
        this.read_books_id = read_books_id;
    }

    public User() {

    }
}
