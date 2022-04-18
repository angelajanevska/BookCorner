package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User username;

    private String text;


    public Comment() {
    }

    public Comment(User username, String text) {
        this.username = username;
        this.text = text;
    }
}
