package com.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.entity.User;
import com.movieflix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User create(User emp) {
		User existing = repository.findByEmail(emp.getEmail());
		try {
			if (existing != null) {
				throw new Exception("Employee already exists with this email");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repository.create(emp);
	}

	@Transactional
	@Override
	public User update(String empId, User emp) {
		User existing = repository.findOne(empId);
		try {
			if (existing == null) {
				throw new Exception("Employee not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repository.update(emp);
	}

}