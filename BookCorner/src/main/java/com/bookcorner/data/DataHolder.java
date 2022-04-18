package com.bookcorner.data;

import com.bookcorner.model.Book;
import com.bookcorner.repository.BookRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataHolder {
    private final BookRepository bookRepository;
    List<Book> books = new ArrayList<>();

    public DataHolder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    void init() throws IOException, CsvValidationException {
        CSVReader bookReader = new CSVReader(new FileReader("src/main/resources/static/data/books.csv"));
        String[] row;
        String image;
        bookReader.readNext();

        while ((row = bookReader.readNext()) != null) {
            String[] barData = Arrays.toString(row).split(",");
            if(barData[18].contains("https://")) {
                books.add(new Book(barData[8], barData[6], barData[4].replace(" ", ""), barData[7], barData[3].replace(" ", ""), barData[18]));
            } else books.add(new Book(barData[8], barData[6], barData[4].replace(" ", ""), barData[7], barData[3].replace(" ", ""), barData[19]));
        }

        this.bookRepository.saveAll(books);
    }
}
