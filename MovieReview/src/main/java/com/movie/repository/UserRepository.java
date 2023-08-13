package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User getUserById(int id);
	public User getUserByEmail(String email);
}
