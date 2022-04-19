package com.bookcorner.service.implementation;

import com.bookcorner.model.Role;
import com.bookcorner.model.User;
import com.bookcorner.model.exceptions.InvalidArgumentsException;
import com.bookcorner.model.exceptions.InvalidUserCredentialsException;
import com.bookcorner.model.exceptions.PasswordsDoNotMatchException;
import com.bookcorner.model.exceptions.UsernameAlreadyExistsException;
import com.bookcorner.repository.UserRepository;
import com.bookcorner.service.AuthService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
