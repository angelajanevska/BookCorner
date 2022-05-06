package com.bookcorner.service.implementation;

import com.bookcorner.model.Book;
import com.bookcorner.model.BookReviews;
import com.bookcorner.model.Rating;
import com.bookcorner.repository.BookReviewsRepository;
import com.bookcorner.service.BookReviewsService;
import com.bookcorner.service.RatingService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class BookReviewsServiceImpl implements BookReviewsService {
    private final BookReviewsRepository bookReviewsRepository;
    private final RatingService ratingService;

    public BookReviewsServiceImpl(BookReviewsRepository bookReviewsRepository, RatingService ratingService) {
        this.bookReviewsRepository = bookReviewsRepository;
        this.ratingService = ratingService;
    }

    @Override
    public void save(String isbn) {
        this.bookReviewsRepository.save(new BookReviews(isbn));
    }

    @Override
    public List<BookReviews> findAll() {
        return this.bookReviewsRepository.findAll();
    }

    @Override
    public Optional<BookReviews> findById(Long id) {
        return this.bookReviewsRepository.findById(id);
    }

    @Override
    public void addReviewToBook(String ISBN, Integer rating) {
        BookReviews bookReviews = this.bookReviewsRepository.findByISBN(ISBN);
        List<Rating> ratings = bookReviews.getReviews();
        ratings.add(this.ratingService.findByRating(rating));
        bookReviews.setReviews(ratings);
        this.bookReviewsRepository.save(bookReviews);
    }

    @Override
    public Double getRating(String isbn) {
//        BookReviews review = this.bookReviewsRepository.findByISBN(isbn);
//        Double sum = 0.0;
//        Integer count = review.getReviews().size();
//        for (Rating rating : review.getReviews()) {
//            sum += rating.getRating();
//        }
//        DecimalFormat df = new DecimalFormat("0.00");
//        return Double.parseDouble(df.format(sum / count));
        return 1.1;
    }
}
