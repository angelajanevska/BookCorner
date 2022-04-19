package com.bookcorner.service;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.Quotes;
import com.bookcorner.model.User;

import java.util.List;
import java.util.Optional;

public interface PersonalBooksService {
    List<PersonalBooks> findAll();
    Optional<PersonalBooks> findByStatus();
    void save(String bookApi, BookStatus status, User user, Integer current_page, List<Quotes> favorite_quotes);
    Optional<PersonalBooks> findByStatus(BookStatus status);

}
