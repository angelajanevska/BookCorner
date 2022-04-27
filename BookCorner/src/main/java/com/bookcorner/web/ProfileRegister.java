package com.bookcorner.web;

import com.bookcorner.model.Book;
import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.User;
import com.bookcorner.repository.UserRepository;
import com.bookcorner.service.BookService;
import com.bookcorner.service.PersonalBooksService;
import com.bookcorner.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/profile", method = {RequestMethod.POST,RequestMethod.DELETE, RequestMethod.GET})
public class ProfileRegister {
    private final PersonalBooksService personalBooksService;
    private final BookService bookService;
    private final UserRepository userRepository;
    private final UserService userService;


    public ProfileRegister(PersonalBooksService personalBooksService, BookService bookService, UserRepository userRepository, UserService userService) {
        this.personalBooksService = personalBooksService;
        this.bookService = bookService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public String getProfilePage(Model model, Authentication authentication, HttpServletRequest request){
//        User user = (User) request.getSession().getAttribute("user");
//        User user = (User) authentication.getPrincipal();
        User user = userService.findByUsername(request.getRemoteUser()).get();

        System.out.println(user.getUsername());
        List<PersonalBooks> wishlistIs = this.personalBooksService.findAll().stream().filter(el -> el.getStatus() == BookStatus.wishlist && el.getUser().getUsername() == user.getUsername()).collect(Collectors.toList());
        List<PersonalBooks> currentlyReadingISBN = this.personalBooksService.findAll().stream().filter(el -> el.getStatus() == BookStatus.currently_reading && el.getUser().getUsername() == user.getUsername()).collect(Collectors.toList());
        List<PersonalBooks> readBooksISBN = this.personalBooksService.findAll().stream().filter(el -> el.getStatus() == BookStatus.read_book && el.getUser().getUsername() == user.getUsername()).collect(Collectors.toList());

        List<Book> wishlist = this.bookService.findAll().stream().filter(el -> wishlistIs.stream().anyMatch(w -> w.getISBN().equals(el.getIsbn()))).collect(Collectors.toList());
        List<Book> currentlyReading = this.bookService.findAll().stream().filter(el -> currentlyReadingISBN.stream().anyMatch(w -> w.getISBN().equals(el.getIsbn()))).collect(Collectors.toList());
        List<Book> readBooks = this.bookService.findAll().stream().filter(el -> readBooksISBN.stream().anyMatch(w -> w.getISBN().equals(el.getIsbn()))).collect(Collectors.toList());


        model.addAttribute("wishlist", wishlist);
        model.addAttribute("currentlyReading", currentlyReading);
        model.addAttribute("readBooks", readBooks);
        model.addAttribute("user",request.getRemoteUser());
        return "profile";
    }

    @PostMapping("/to-currently-reading/{isbn}")
    public String changeToCurrentlyReading(@PathVariable String isbn){
        this.personalBooksService.editStatus(isbn, BookStatus.currently_reading);
        return "redirect:/profile";
    }

    @PostMapping("/to-read-books/{isbn}")
    public String changeToReadBooks(@PathVariable String isbn){
        this.personalBooksService.editStatus(isbn, BookStatus.read_book);
        return "redirect:/profile";
    }

    @DeleteMapping("/delete/{isbn}")
    public String deleteFromWishlist(@PathVariable String isbn){
        this.personalBooksService.deleteFromWishlist(isbn);
        return "redirect:/profile";
    }

}
