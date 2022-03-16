package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Book book_id;

    @OneToMany
    private List<Comment> comment;

    private Integer rating;

    public Reviews() {
    }
}
