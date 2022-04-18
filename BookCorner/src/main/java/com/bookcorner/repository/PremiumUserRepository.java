package com.bookcorner.repository;

import com.bookcorner.model.Premium_user;
import com.bookcorner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PremiumUserRepository extends JpaRepository<Premium_user, Long> {
    Optional<Premium_user> findByUsername(String username);
}
