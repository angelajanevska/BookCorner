package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private String sex;
    private LocalDate birthday;

    @OneToMany
    private List<PersonalBooks> books;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String username, String password, String name, String surname, String email, String sex, LocalDate birthday, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.sex = sex;
        this.birthday = birthday;
        this.role = role;
        this.books = new ArrayList<>();
    }

    public User() {

    }
}
