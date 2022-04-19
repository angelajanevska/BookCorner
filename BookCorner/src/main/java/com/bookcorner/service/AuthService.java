package com.bookcorner.service;

import com.bookcorner.model.User;
import java.time.LocalDate;

public interface AuthService {
    User login(String username, String password);
//    User register(String name, String surname, String username, String email, LocalDate dateOfBirth, String password, String repeatedPassword);
}
