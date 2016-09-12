package com.movieflix.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.app.entity.User;
import com.movieflix.app.exception.EntityAlreadyExistException;
import com.movieflix.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		try {
			if (existing != null) {
				throw new EntityAlreadyExistException("User already exists with this email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repository.create(user);
	}

	@Transactional
	@Override
	public User update(String userId, User user) {
		User existing = repository.findOne(userId);
		try {
			if (existing == null) {
				throw new Exception("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repository.update(user);
	}
	
	public User findByEmail(User user){
		User existing = repository.findByEmail(user.getEmail());
		try {
			if (existing == null) {
				throw new Exception("User not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(existing.getPassword().equals(user.getPassword())){
			return existing;
		}
		return null;
	}

}