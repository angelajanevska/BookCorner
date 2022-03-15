package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
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

    @OneToMany
    private List<Wishlist> wishlist;

    @OneToMany
    private List<Currently_reading> currently_reading;

    @OneToMany
    private List<Read_books> read_books_id;
}
