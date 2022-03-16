package com.bookcorner.repository;

import com.bookcorner.model.Read_books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadBooksRepository extends JpaRepository<Long, Read_books> {
}
