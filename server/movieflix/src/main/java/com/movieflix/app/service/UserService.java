package com.movieflix.app.service;

import java.util.List;

import com.movieflix.app.entity.User;

public interface UserService {

	public User create(User user);

	public User update(String userId, User user);
	
	public User findByEmail(User user);
	
	public User login(User user);

}