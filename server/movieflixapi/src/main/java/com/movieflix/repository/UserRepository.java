package com.movieflix.repository;

import com.movieflix.entity.User;

public interface UserRepository {

	public User create(User user);

	public User update(User user);
	
	public User findOne(String userId);
	
	public User findByEmail(String email);

}
