package com.bookcorner.service.implementation;

import com.bookcorner.model.BookStatus;
import com.bookcorner.model.PersonalBooks;
import com.bookcorner.model.Quotes;
import com.bookcorner.model.User;
import com.bookcorner.model.exceptions.BookNotFoundException;
import com.bookcorner.repository.PersonalBooksRepository;
import com.bookcorner.service.PersonalBooksService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalBooksServiceImpl implements PersonalBooksService {
    private final PersonalBooksRepository personalBooksRepository;

    public PersonalBooksServiceImpl(PersonalBooksRepository personalBooksRepository) {
        this.personalBooksRepository = personalBooksRepository;
    }

    @Override
    public List<PersonalBooks> findAll() {
        return this.personalBooksRepository.findAll();
    }

    @Override
    public PersonalBooks save(String isbn, BookStatus status, User user, Integer current_page, List<Quotes> favorite_quotes) {
        PersonalBooks personalBooks = new PersonalBooks(isbn, status, user, current_page, favorite_quotes);
        return this.personalBooksRepository.save(personalBooks);
    }

    @Override
    public Optional<PersonalBooks> findByStatus(BookStatus status) {
        return this.personalBooksRepository.findByStatus(status);
    }

    @Override
    public Optional<PersonalBooks> findByStatusAndUser(BookStatus status, User user) {
        return this.personalBooksRepository.findByStatusAndUser(status, user);
    }

    @Override
    public void editStatus(String isbn, BookStatus status, LocalDate finishedBookDate) {
        PersonalBooks book = this.personalBooksRepository.findByISBN(isbn).orElseThrow();
        book.setStatus(status);
        book.setFinishedBookDate(finishedBookDate);
        this.personalBooksRepository.save(book);
    }

    @Override
    public void deleteFromWishlist(String isbn) {
        PersonalBooks book = personalBooksRepository.findByISBN(isbn).orElseThrow(BookNotFoundException::new);
        personalBooksRepository.deleteById(book.getId());
    }

    @Override
    public Optional<PersonalBooks> findById(Long id) {
        return this.personalBooksRepository.findById(id);
    }

    @Override
    public Optional<PersonalBooks> findByUser(User user) {
        return this.personalBooksRepository.findByUser(user);
    }

    @Override
    public Optional<PersonalBooks> findAllByUser(User user) {
        return this.personalBooksRepository.findAllByUser(user);
    }

}
