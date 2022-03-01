package com.bookcorner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BookcornerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookcornerApplication.class, args);
    }

}
