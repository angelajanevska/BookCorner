package com.bookcorner.web;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.User;
import com.bookcorner.service.BookService;
import com.bookcorner.service.EmailSenderService;
import com.bookcorner.service.PersonalBooksService;
import com.bookcorner.service.UserService;
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
    private final UserService userService;
    @Autowired
    private final EmailSenderService emailSenderService;

    public HomeController(BookService bookService, PersonalBooksService personalBooksService, UserService userService, EmailSenderService emailSenderService) {
        this.bookService = bookService;
        this.personalBooksService = personalBooksService;
        this.userService = userService;
        this.emailSenderService = emailSenderService;
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

    @PostMapping("/sendMail")
    public String sendMail(@RequestParam String email, @RequestParam String subject, @RequestParam String mailMessage){
        this.emailSenderService.sendEmail(email, subject, mailMessage);
        return "redirect:/";
    }
}
