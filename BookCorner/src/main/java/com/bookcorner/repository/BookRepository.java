package com.bookcorner.repository;

import com.bookcorner.model.Book;
import com.bookcorner.service.BookService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    Optional<Book> findById(Long aLong);

    Optional<Book> findByTitle(String title);
}
