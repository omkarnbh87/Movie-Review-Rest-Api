package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

	public Movies getMovieById(int id);
	public Movies findByname(String movie_name);
	
}
