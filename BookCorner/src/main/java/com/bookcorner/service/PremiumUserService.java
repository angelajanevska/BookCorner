package com.bookcorner.service;

import com.bookcorner.model.Premium_user;
import com.bookcorner.model.User;

import java.util.List;
import java.util.Optional;

public interface PremiumUserService {
    List<Premium_user> findAll();

    Optional<Premium_user> findByUsername(String username);
}
