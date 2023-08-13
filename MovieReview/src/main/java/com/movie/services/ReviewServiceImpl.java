package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Review;
import com.movie.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public List<Review> viewReview() {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Override
	public int addReview(Review review) {
		// TODO Auto-generated method stub
		if(reviewRepository.save(review) != null)
			return 1;
		return 0;
	}

}
