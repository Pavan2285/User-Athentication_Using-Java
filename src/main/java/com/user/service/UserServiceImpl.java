package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.domain.User;
import com.user.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		return "Saved Successfully..!!";
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll();
	}

	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
