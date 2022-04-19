package com.bookcorner.service.implementation;

import com.bookcorner.model.PersonalBooks;
import com.bookcorner.repository.PersonalBooksRepository;
import com.bookcorner.service.PersonalBooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalBooksServiceImpl implements PersonalBooksService {
    private final PersonalBooksRepository personalBooksRepository;

    public PersonalBooksServiceImpl(PersonalBooksRepository personalBooksRepository) {
        this.personalBooksRepository = personalBooksRepository;
    }

    @Override
    public List<PersonalBooks> findAll() {
        return this.personalBooksRepository.findAll();
    }

    @Override
    public Optional<PersonalBooks> findByStatus() {
        return Optional.empty();
    }
}
