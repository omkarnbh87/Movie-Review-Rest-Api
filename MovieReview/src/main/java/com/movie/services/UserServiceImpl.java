package com.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.repository.UserRepository;
import com.movie.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public int createUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.save(user) != null)
			return 1;
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		User dbUser = userRepository.getUserById(user.getId());
		if(user.getEmail() != null)
			dbUser.setEmail(user.getEmail());
		if(user.getMobile() != null)
			dbUser.setMobile(user.getMobile());
		if(user.getName() != null)
			dbUser.setName(user.getName());
		if(user.getPassword() != null)
			dbUser.setPassword(user.getPassword());
		
		if(userRepository.save(dbUser) != null)
			return 1;
		return 0;
	}

	@Override
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		if(userRepository.getUserById(id) == null)
			return 0;
		userRepository.deleteById(id);
		return 1;
	}

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		User dbUser = userRepository.getUserByEmail(user.getEmail());
		if(dbUser == null)
			return null;
		if(dbUser.getPassword() == user.getPassword())
			return dbUser;
		return null;
	}

	

}
