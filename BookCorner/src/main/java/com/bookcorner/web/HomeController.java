package com.bookcorner.web;

import com.bookcorner.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,6));
        return "index";
//        return "header";
    }

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll().subList(0,20));
        return "books";
//        return "header";
    }

    @GetMapping("/contact")
    public String getContactUs(){
        return "contact";
    }


}
