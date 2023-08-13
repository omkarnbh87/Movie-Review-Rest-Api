package com.movie.services;

import com.movie.model.User;

public interface UserService {

	public int createUser(User user);
	public int updateUser(User user);
	public int deleteUserById(int id);
	public User userLogin(User user);
}
