package com.bookcorner.repository;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalBooksRepository extends JpaRepository<PersonalBooks, Long> {

    Optional<PersonalBooks> findByStatus(BookStatus status);

}
