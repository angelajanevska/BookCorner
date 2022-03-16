package com.bookcorner.repository;

import com.bookcorner.model.Premium_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumUserRepository extends JpaRepository<Premium_user, Long> {
}
