package com.bookcorner.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Read_books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user_id;

    @ManyToOne
    private Book book_id;

    private String personal_comment;

    @OneToMany
    private List<Quotes> favorite_quotes;
}
