package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
