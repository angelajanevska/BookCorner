package com.bookcorner.service;

import com.bookcorner.model.Currently_reading;
import com.bookcorner.model.Read_books;

import java.util.List;
import java.util.Optional;

public interface ReadBooksService {
    List<Read_books> findAll();
    Optional<Read_books> findById(Long id);
}
