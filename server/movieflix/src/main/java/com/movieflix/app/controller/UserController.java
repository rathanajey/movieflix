package com.movieflix.app.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.movieflix.app.entity.User;
import com.movieflix.app.exception.EntityAlreadyExistException;
import com.movieflix.app.exception.EntityNotFoundException;
import com.movieflix.app.service.UserService;
import com.movieflix.app.session.SessionDetails;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user, HttpServletResponse response) {
		try{
			User created = service.create(user);
				SessionDetails.setSession(created);
				System.out.println("USER " + created.getEmail() + " WAS CREATED. LOGGING IN NOW");
				response.setStatus(HttpServletResponse.SC_CREATED);
				return created;
		}
		catch(EntityAlreadyExistException e){
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@RequestBody User user, HttpServletResponse response) {
		try{
			User existing = service.login(user);
			if(existing != null){
				SessionDetails.setSession(existing);
				System.out.println("USER " + existing.getEmail() + " WAS FOUND. LOGGING IN NOW");
				response.setStatus(HttpServletResponse.SC_CREATED);
				return existing;
			}
			else{
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return existing;
			}
		}
		catch(EntityNotFoundException e){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "logout")
	public void logout() {
		SessionDetails.setSession(null);
		System.out.println("USER IS LOGGED OUT NOW");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("id") String userId, @RequestBody User user, HttpServletResponse response) {
		try{
			User updated = service.update(userId, user);
			response.setStatus(HttpServletResponse.SC_OK);
			return updated;
		}
		catch(EntityNotFoundException e){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}