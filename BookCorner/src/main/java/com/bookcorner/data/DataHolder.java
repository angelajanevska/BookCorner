package com.bookcorner.data;

import com.bookcorner.model.*;
import com.bookcorner.repository.BookRepository;
import com.bookcorner.repository.BookReviewsRepository;
import com.bookcorner.repository.RatingRepository;
import com.bookcorner.repository.UserRepository;
import com.bookcorner.service.BookReviewsService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataHolder {
    private final BookRepository bookRepository;
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookReviewsRepository bookReviewsRepository;
    private final BookReviewsService bookReviewsService;

    List<Book> books = new ArrayList<>();

    public DataHolder(BookRepository bookRepository, RatingRepository ratingRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, BookReviewsRepository reviewsRepository, BookReviewsService bookReviewsService) {
        this.bookRepository = bookRepository;
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.bookReviewsRepository = reviewsRepository;

        this.bookReviewsService = bookReviewsService;
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
                books.add(new Book(barData[8], barData[6], barData[4].replace(" ", ""), "selfID","description",barData[7], barData[3].replace(" ", ""), barData[18]));
            } else books.add(new Book(barData[8], barData[6], barData[4].replace(" ", ""), "selfID","description", barData[7], barData[3].replace(" ", ""), barData[19]));
            if(barData[4] != null)
            bookReviewsRepository.save(new BookReviews(barData[4].replace(" ", "")));
        }
        this.bookRepository.saveAll(books);



        for(int i = 1; i <= 5; i++){
            this.ratingRepository.save(new Rating(i));
        }

        this.userRepository.save(new User("angela", "s", "stev", "ss@gmail.com", Date.valueOf(LocalDate.now()), Role.ROLE_USER, passwordEncoder.encode("stev")));
        this.userRepository.save(new User("angela", "j", "jan", "jj@gmail.com", Date.valueOf(LocalDate.now()), Role.ROLE_PREMIUM, passwordEncoder.encode("jan")));

        this.userRepository.save(new User("admin", "admin", "admin", "admin@gmail.com", Date.valueOf(LocalDate.now()), Role.ROLE_ADMIN, passwordEncoder.encode("admin")));
        this.bookReviewsService.addReviewToBook("439023483", this.ratingRepository.findByRating(1).getRating());
        this.bookReviewsService.addReviewToBook("439023483", this.ratingRepository.findByRating(5).getRating());
        this.bookReviewsService.addReviewToBook("439023483", this.ratingRepository.findByRating(5).getRating());
        this.bookReviewsService.addReviewToBook("439023483", this.ratingRepository.findByRating(4).getRating());

    }
}
