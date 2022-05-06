package com.bookcorner.repository;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalBooksRepository extends JpaRepository<PersonalBooks, Long> {

    Optional<PersonalBooks> findByStatus(BookStatus status);
    Optional<PersonalBooks> findByStatusAndUser(BookStatus status, User user);
    Optional<PersonalBooks> findAllByUser(User user);
    Optional<PersonalBooks> findByUser(User user);
    Optional<PersonalBooks> findByISBN(String isbn);
    void deleteByISBN(String ISBN);
}
