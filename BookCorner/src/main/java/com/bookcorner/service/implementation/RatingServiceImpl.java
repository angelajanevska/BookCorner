package com.bookcorner.service.implementation;

import com.bookcorner.model.Rating;
import com.bookcorner.repository.RatingRepository;
import com.bookcorner.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public void save(Integer rating) {
        this.ratingRepository.save(new Rating(rating));
    }

    @Override
    public Rating findByRating(Integer rating) {
        return this.ratingRepository.findByRating(rating);
    }

    @Override
    public void addRating(Integer rating) {
        this.ratingRepository.save(new Rating(rating));
    }
}
