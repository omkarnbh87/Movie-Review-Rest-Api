package com.movie.services;

import java.util.List;

import com.movie.model.Review;

public interface ReviewService {

	public List<Review> viewReview();
	public int addReview(Review review);
}
