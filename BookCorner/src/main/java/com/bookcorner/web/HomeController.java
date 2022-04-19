package com.bookcorner.web;

import com.bookcorner.model.Book;
import com.bookcorner.model.BookStatus;
import com.bookcorner.model.User;
import com.bookcorner.service.BookService;
import com.bookcorner.service.PersonalBooksService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("")
public class HomeController {
    private final BookService bookService;
    private final PersonalBooksService personalBooksService;

    public HomeController(BookService bookService, PersonalBooksService personalBooksService) {
        this.bookService = bookService;
        this.personalBooksService = personalBooksService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,6));
        return "index";
    }

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,20));
        return "books";
    }


    @PostMapping("/book-wishlist/{isbn}")
    public String addBookToWishlist(@PathVariable String isbn, Authentication authentication){

        User user = (User) authentication.getPrincipal();
        personalBooksService.save(isbn, BookStatus.WISHLIST, user, null, null);
        return "redirect:/books";

    }

    @GetMapping("/contact")
    public String getContactUs(){
        return "contact";
    }


}
