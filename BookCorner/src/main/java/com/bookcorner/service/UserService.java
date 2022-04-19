package com.bookcorner.service;

import com.bookcorner.model.Role;
import com.bookcorner.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    List<User> findAll();

    User register(String name, String surname, String username, String email, LocalDate dateOfBirth, String password, String repeatedPassword);
}
