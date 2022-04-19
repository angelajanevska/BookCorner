package com.bookcorner.service;

import com.bookcorner.model.Rating;

public interface RatingService {
    void save(Integer rating);
    Rating findByRating(Integer rating);
    void addRating(Integer rating);
}
