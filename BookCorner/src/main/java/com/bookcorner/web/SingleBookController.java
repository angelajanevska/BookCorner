package com.bookcorner.web;

import com.bookcorner.model.Book;
import com.bookcorner.service.BookReviewsService;
import com.bookcorner.service.BookService;
import com.bookcorner.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class SingleBookController {
    private final BookService bookService;
    private final BookReviewsService bookReviewsService;
    private final RatingService ratingService;

    public SingleBookController(BookService bookService, BookReviewsService bookReviewsService, RatingService ratingService) {
        this.bookService = bookService;
        this.bookReviewsService = bookReviewsService;
        this.ratingService = ratingService;
    }

    @GetMapping("/{isbn}")
    public String getBook(@PathVariable String isbn, Model model){
        if(bookService.findByIsbn(isbn).isPresent()) {
            Book book = bookService.findByIsbn(isbn).get();
            model.addAttribute("book", book);
            model.addAttribute("ratings", ratingService.findAll());
            model.addAttribute("allReviews", bookReviewsService.getRating(isbn));
            return "books-single";
        }
        return "redirect:/book?error=bookNotFound";
    }
    @PostMapping("/addRating/{isbn}")
    public String addRating(@PathVariable String isbn, @RequestParam String rate){
        this.bookReviewsService.addReviewToBook(isbn, Integer.parseInt(rate));
        return "redirect:/book/{isbn}";
    }
}
