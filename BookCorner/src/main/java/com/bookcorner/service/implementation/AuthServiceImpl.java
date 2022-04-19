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

//    @Override
//    public User register(String name, String surname, String username, String email, LocalDate dateOfBirth, String password, String repeatedPassword) {
//        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
//            throw new InvalidArgumentsException();
//        if (!password.equals(repeatedPassword))
//            throw new PasswordsDoNotMatchException();
//        if(this.userRepository.findByUsername(username).isPresent()
//                || this.userRepository.findByUsername(username).isPresent())
//            throw new UsernameAlreadyExistsException(username);
//
//        Date date = Date.valueOf(dateOfBirth);
//        return this.userRepository.save(new User(name,surname,username,email,date,Role.ROLE_USER,password));
//    }
}
