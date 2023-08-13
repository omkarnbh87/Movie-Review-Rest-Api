package com.movie.services;

import java.util.List;

import com.movie.model.Movies;

public interface MoviesService {

	public int addMovie(Movies movies);
	public int updateMovie(Movies movies);
	public int deleteMovie(int id);
	public List<Movies> viewMovies();
	
}
