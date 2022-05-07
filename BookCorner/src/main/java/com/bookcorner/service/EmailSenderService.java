package com.bookcorner.service;

import com.bookcorner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    private final UserService userService;

    public EmailSenderService(UserService userService) {
        this.userService = userService;
    }

    public void sendEmail(String username) {
        User user = userService.findByUsername(username).get();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("angela.stevkovska3@gmail.com");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("BookCorner - Your statistics");
        Integer[] readBooksPerMonth =  this.userService.findByMonthOfSpecificYear(LocalDate.now().getYear());

        String bodyText = "January: " + readBooksPerMonth[0] +"\n"
                + "February: " + readBooksPerMonth[1] +"\n"
                + "March: " + readBooksPerMonth[2] +"\n"
                + "April: " + readBooksPerMonth[3] +"\n"
                + "May: " + readBooksPerMonth[4] +"\n"
                + "June: " + readBooksPerMonth[5] +"\n"
                + "July: " + readBooksPerMonth[6] +"\n"
                + "August: " + readBooksPerMonth[7] +"\n"
                + "September: " + readBooksPerMonth[8] +"\n"
                + "October: " + readBooksPerMonth[9] +"\n"
                + "November: " + readBooksPerMonth[10] +"\n"
                + "December: " + readBooksPerMonth[11] +"\n" ;
        mailMessage.setText(bodyText);

        mailSender.send(mailMessage);
        System.out.println("Mail sent.");
    }
}
