package com.bookcorner.service.implementation;

import com.bookcorner.model.Wishlist;
import com.bookcorner.repository.WishlistRepository;
import com.bookcorner.service.WishlistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {
    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public List<Wishlist> findAll() {
        return this.wishlistRepository.findAll();
    }

    @Override
    public Optional<Wishlist> findById(Long id) {
        return this.wishlistRepository.findById(id);
    }
}
