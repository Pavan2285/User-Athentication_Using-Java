package com.user.service;

import java.util.List;

import com.user.domain.User;

public interface UserService {
	public String saveUser(User user);
	public List<User> getAllUsers();
	public String updateUser(User user);
}
