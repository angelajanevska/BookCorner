package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private Date dateOfBirth;

    @OneToMany
    private List<PersonalBooks> books;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String name, String surname, String username, String email, Date dateOfBirth, Role role, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.books = new ArrayList<>();
    }

    public User() {

    }
}
