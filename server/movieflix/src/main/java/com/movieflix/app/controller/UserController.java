package com.movieflix.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.app.entity.User;
import com.movieflix.app.service.UserService;
import com.movieflix.session.SessionDetails;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		User created = service.create(user);
		SessionDetails.setSession(created);
		System.out.println("USER " + created.getEmail() + " WAS CREATED. LOGGING IN NOW");
		
		return created; 
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@RequestBody User user) {
		User existing = service.findByEmail(user);
		if(existing != null){
			SessionDetails.setSession(existing);
			System.out.println("USER " + existing.getEmail() + " WAS FOUND. LOGGING IN NOW");
		}
		
		return existing; 
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "logout")
	public void logout() {
		SessionDetails.setSession(null);
		System.out.println("USER IS LOGGED OUT NOW");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String userId, @RequestBody User user) {
		return service.update(userId, user);
	}
	
}