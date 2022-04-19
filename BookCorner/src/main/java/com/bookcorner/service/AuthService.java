package com.bookcorner.service;

import com.bookcorner.model.User;
import org.springframework.stereotype.Service;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
