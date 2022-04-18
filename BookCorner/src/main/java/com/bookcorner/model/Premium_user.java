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
    private String username;

    public Premium_user() {
    }
}
