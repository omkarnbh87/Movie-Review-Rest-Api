package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.model.Review;
import com.movie.model.User;
import com.movie.services.ReviewService;
import com.movie.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User user){
		System.out.println("userLogin");
		User dbUser = service.userLogin(user);
		return ResponseEntity.ok(dbUser);
		
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		
		if(service.createUser(user) != 0)
			return ResponseEntity.ok("Successfully created");
		return ResponseEntity.ok("Something went wrong");

	}

	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		if(service.updateUser(user) != 0)
			return ResponseEntity.ok("Successfully updated");
		return ResponseEntity.ok("Something went wrong");

	}

	@GetMapping("/viewReview")
	public ResponseEntity<List<Review>> viewReview() {
		List<Review> reviews = reviewService.viewReview();
		return ResponseEntity.ok(reviews);

	}

	@PostMapping("/addReview")
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		
		if(reviewService.addReview(review) != 0)
			return ResponseEntity.ok("Successfully review added");
		return ResponseEntity.ok(" Something went wrong ");

	}
}
