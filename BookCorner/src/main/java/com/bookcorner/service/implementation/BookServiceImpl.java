package com.bookcorner.service.implementation;

import com.bookcorner.model.Book;
import com.bookcorner.model.BookReviews;
import com.bookcorner.repository.BookRepository;
import com.bookcorner.service.BookReviewsService;
import com.bookcorner.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookReviewsService bookReviewsService;

    public BookServiceImpl(BookRepository bookRepository, BookReviewsService bookReviewsService) {
        this.bookRepository = bookRepository;
        this.bookReviewsService = bookReviewsService;
    }

    @Override
    public void save(String title, String author, String isbn, String selfID, String description, String release_date, String pages, String coverURL) {
        Book book = new Book(title, author, isbn, selfID,description, release_date, pages, coverURL);
        this.bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return this.bookRepository.findByTitle(title);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findBySelfID(String selfID) {
        return this.bookRepository.findBySelfID(selfID);
    }

    @Override
    public Book highestRated() {
        BookReviews maxBookRating = new BookReviews();
        Double maxRating = 0.0;
        for (BookReviews booksReview : this.bookReviewsService.findAll()) {
            Double rating = this.bookReviewsService.getRating(booksReview.getISBN());
            if (rating > maxRating) {
                maxRating = rating;
                maxBookRating = booksReview;
            }
        }
        return bookRepository.findByIsbn(maxBookRating.getISBN()).get();
    }

}
