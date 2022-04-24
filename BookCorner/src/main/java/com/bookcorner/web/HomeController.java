package com.bookcorner.web;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.User;
import com.bookcorner.service.BookService;
import com.bookcorner.service.PersonalBooksService;
import com.bookcorner.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final BookService bookService;
    private final PersonalBooksService personalBooksService;
    private final UserService userService;

    public HomeController(BookService bookService, PersonalBooksService personalBooksService, UserService userService) {
        this.bookService = bookService;
        this.personalBooksService = personalBooksService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,6));
        return "home";
//        return "header";
    }

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,20));
        return "books";
//        return "header";
    }

    @PostMapping("/book-wishlist/{isbn}")
    public String addBookToWishlist(@PathVariable String isbn, Authentication authentication){
        User user = (User) authentication.getPrincipal();
        PersonalBooks book = personalBooksService.save(isbn, BookStatus.wishlist, user, null, null);
        userService.updateBooks(book, user.getUsername());
        return "redirect:/books";

    }

    @GetMapping("/contact")
    public String getContactUs(){
        return "contact";
    }
}
