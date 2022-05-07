package com.bookcorner.service.implementation;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.Role;
import com.bookcorner.model.User;
import com.bookcorner.model.exceptions.InvalidArgumentsException;
import com.bookcorner.model.exceptions.PasswordsDoNotMatchException;
import com.bookcorner.model.exceptions.UsernameAlreadyExistsException;
import com.bookcorner.repository.PersonalBooksRepository;
import com.bookcorner.repository.UserRepository;
import com.bookcorner.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PersonalBooksRepository personalBooksRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, PersonalBooksRepository personalBooksRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.personalBooksRepository = personalBooksRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User register(String name, String surname, String username, String email, LocalDate dateOfBirth, String password, String repeatedPassword) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidArgumentsException();
        if (!password.equals(repeatedPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent()
                || this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        return this.userRepository.save(new User(name,surname,username,email,Date.valueOf(dateOfBirth),Role.ROLE_USER,passwordEncoder.encode(password)));

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Integer[] findByMonthOfSpecificYear(Integer year) {
        List<PersonalBooks> readBooks = this.personalBooksRepository.findAll().stream().filter(el -> el.getStatus().equals(BookStatus.readBook)).collect(Collectors.toList());
        Integer[] listByMonth = new Integer[12];
        for(int i = 0; i < 12; i++){
            int monthIndex = i+1;
            listByMonth[i] = Math.toIntExact(readBooks.stream().filter(el -> el.getFinishedBookDate().getMonthValue() == monthIndex).count());
        }
        return listByMonth;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }


}
