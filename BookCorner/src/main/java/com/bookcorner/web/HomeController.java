package com.bookcorner.web;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.User;
import com.bookcorner.service.BookService;
import com.bookcorner.service.EmailSenderService;
import com.bookcorner.service.PersonalBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
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
        return "index-page";
//        return "header";
    }

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", this.bookService.findAll().subList(0,20));
        model.addAttribute("topBook", this.bookService.findById((long)1).get());
        return "books";
//        return "header";
    }

    @PostMapping("/book-wishlist/{isbn}")
    public String addBookToWishlist(@PathVariable String isbn, Authentication authentication){
        User user = (User) authentication.getPrincipal();
         personalBooksService.save(isbn, BookStatus.wishlist, user, null, null);
//        userService.updateBooks(book, user.getUsername());
        return "redirect:/books";

    }

    @GetMapping("/contact")
    public String getContactUs(){
        return "contact";
    }

}
