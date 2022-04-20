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

    PersonalBooks save(String bookApi, BookStatus status, User user, Integer current_page, List<Quotes> favorite_quotes);

    Optional<PersonalBooks> findByStatus(BookStatus status);

    Optional<PersonalBooks> findByStatusAndUser(BookStatus status, User user);

    void editStatus(String isbn, BookStatus status);

    void deleteFromWishlist(String isbn);

    Optional<PersonalBooks> findById(Long id);

    Optional<PersonalBooks> findByUser(User user);

}
