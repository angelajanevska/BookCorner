package com.bookcorner.web;

import com.bookcorner.model.Book;
import com.bookcorner.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class SingleBookController {
    private final BookService bookService;

    public SingleBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable String id, Model model){
        if(bookService.findByIsbn(id).isPresent()) {
            Book book = bookService.findByIsbn(id).get();
            model.addAttribute("book", book);
            return "books-single";
        }
        return "redirect:/book?error=bookNotFound";
    }
}
