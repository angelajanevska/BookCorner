package com.bookcorner;

import com.bookcorner.model.Book;
import com.bookcorner.repository.impl.BookRepositoryImpl;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
@ServletComponentScan
public class BookcornerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookcornerApplication.class, args);

    }

    @PostConstruct
    public void init() throws IOException, CsvValidationException {
        BookRepositoryImpl bookRepository = null;
        CSVReader bookReader = new CSVReader(new FileReader("src/main/resources/data.csv"));
        String[] row;
        int flag = 0;
        Random random = new Random();

        while((row = bookReader.readNext())!= null){
            String []barData = Arrays.toString(row).split(",");
                bookRepository.save(barData[8], barData[6], barData[7], Integer.decode(barData[3]));
        }
    }


}
