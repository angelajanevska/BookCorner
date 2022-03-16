package com.bookcorner.repository;

import com.bookcorner.model.Currently_reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentlyReadingRepository extends JpaRepository<Currently_reading, Long> {
}
