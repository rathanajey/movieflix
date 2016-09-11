package com.movieflix.app.repository;

import com.movieflix.app.entity.User;

public interface UserRepository {

	public User create(User user);

	public User update(User user);
	
	public User findOne(String userId);
	
	public User findByEmail(String email);

}
