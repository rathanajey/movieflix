package com.movieflix.service;

import java.util.List;

import com.movieflix.entity.User;

public interface UserService {

	public User create(User user);

	public User update(String userId, User user);

}