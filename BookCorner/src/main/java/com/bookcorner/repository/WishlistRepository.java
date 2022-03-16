package com.bookcorner.repository;

import com.bookcorner.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Long, Wishlist> {

}
