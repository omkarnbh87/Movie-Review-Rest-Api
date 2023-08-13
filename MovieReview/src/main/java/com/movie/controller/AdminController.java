package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.model.Movies;
import com.movie.services.MoviesService;
import com.movie.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	MoviesService moviesService;
	@Autowired
	UserService userService;
	
	@PostMapping("/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody Movies movies) {
		System.out.println("addMovie");
		if(moviesService.addMovie(movies) != 0)
			return ResponseEntity.ok("Successfully added");
		return ResponseEntity.ok("Something went wrong");

	}

	@PutMapping("/updateMovie")
	public ResponseEntity<String> updateMovie(@RequestBody Movies movies) {
		System.out.println("updateMovie");
		if(moviesService.updateMovie(movies) != 0)
			return ResponseEntity.ok("Successfully update");
		return ResponseEntity.ok("Something went wrong");

	}

	@DeleteMapping("/deleteMovie/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable int id) {
		System.out.println("deleteMovie");
		if(moviesService.deleteMovie(id) != 0)
		    return ResponseEntity.ok("Successfully deleted");
		return ResponseEntity.ok("Something went wrong");

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int  id) {
		System.out.println("deleteUser");
		if(userService.deleteUserById(id) != 0)
		    return ResponseEntity.ok("Successfully deleted");
		return ResponseEntity.ok("Something went wrong");

	}
	
	@GetMapping("/viewMovies")
	public ResponseEntity<List<Movies>> viewAllMovies(){
		System.out.println("viewMovies");
		List<Movies> movies = moviesService.viewMovies();
		return ResponseEntity.ok(movies);
	}

}
