package com.bookcorner.service;

import com.bookcorner.model.Currently_reading;

import java.util.List;
import java.util.Optional;

public interface CurrentlyReadingService {
    List<Currently_reading> findAll();

    Optional<Currently_reading> findById(Long id);

}
