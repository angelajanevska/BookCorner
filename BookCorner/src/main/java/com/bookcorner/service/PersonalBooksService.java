package com.bookcorner.service;

import com.bookcorner.model.PersonalBooks;

import java.util.List;
import java.util.Optional;

public interface PersonalBooksService {
    List<PersonalBooks> findAll();
    Optional<PersonalBooks> findByStatus();
}
