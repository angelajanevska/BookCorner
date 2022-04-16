package com.bookcorner.service;

import com.bookcorner.model.Book;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public interface BookService {
    void save(String title, String author, String isbn, String release_date, String pages);

    void saveBookInit(String title, String author, String isbn, String release_date, String pages) throws IOException, CsvValidationException;

}
