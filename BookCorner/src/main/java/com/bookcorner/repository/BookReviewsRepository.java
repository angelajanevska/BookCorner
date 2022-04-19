package com.bookcorner.repository;

import com.bookcorner.model.BookReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookReviewsRepository extends JpaRepository<BookReviews, Long> {

    BookReviews findByISBN(String isbn);
}
