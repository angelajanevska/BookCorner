package com.bookcorner.service.implementation;

import com.bookcorner.model.Premium_user;
import com.bookcorner.repository.PremiumUserRepository;
import com.bookcorner.service.PremiumUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PremiumUserServiceImpl implements PremiumUserService {
    private final PremiumUserRepository premiumUserRepository;

    public PremiumUserServiceImpl(PremiumUserRepository premiumUserRepository) {
        this.premiumUserRepository = premiumUserRepository;
    }

    @Override
    public List<Premium_user> findAll() {
        return this.premiumUserRepository.findAll();
    }

    @Override
    public Optional<Premium_user> findByUsername(String username) {
        return this.premiumUserRepository.findByUsername(username);
    }
}
