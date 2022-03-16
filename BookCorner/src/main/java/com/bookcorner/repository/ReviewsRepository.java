package com.bookcorner.repository;

import com.bookcorner.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Long, Reviews> {
}
