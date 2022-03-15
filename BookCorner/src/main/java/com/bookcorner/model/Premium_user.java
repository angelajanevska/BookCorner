package com.bookcorner.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Premium_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

}
