package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movies;
import com.movie.repository.MoviesRepository;

@Service
public class MovieServiceImpl implements MoviesService {

	@Autowired
	MoviesRepository moviesRepository;
	
	@Override
	public int addMovie(Movies movies) {
		// TODO Auto-generated method stub
		if(moviesRepository.save(movies) != null)
			return 1;
		return 0;
	}

	@Override
	public int updateMovie(Movies movies) {
		// TODO Auto-generated method stub
		Movies dbMovie = moviesRepository.getMovieById(movies.getId());
		if(movies.getMovie_name() != null)
			dbMovie.setMovie_name(movies.getMovie_name());
		if(movies.getRelease_date() != null)
			dbMovie.setRelease_date(movies.getRelease_date());
		if(moviesRepository.save(dbMovie) != null)
			return 1;
		return 0;
	}

	@Override
	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		if(moviesRepository.getMovieById(id) == null)
			return 0;
		moviesRepository.deleteById(id);
		return 1;
	}

	@Override
	public List<Movies> viewMovies() {
		// TODO Auto-generated method stub
		
		return moviesRepository.findAll();
	}

}
