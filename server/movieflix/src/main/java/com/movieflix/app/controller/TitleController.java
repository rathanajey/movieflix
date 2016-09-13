package com.movieflix.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.movieflix.app.entity.Title;
import com.movieflix.app.exception.EntityAlreadyExistException;
import com.movieflix.app.exception.EntityNotFoundException;
import com.movieflix.app.service.TitleService;
import com.movieflix.app.session.SessionDetails;

@RestController
@RequestMapping(value = "titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TitleController {

	public  static final String ADMIN_ROLE = "admin";
	public  static final String USER_ROLE = "user";
	
	@Autowired
	private TitleService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title createTitle(@RequestBody Title title,  HttpServletResponse response) {
		if(SessionDetails.getUserRole().equals(ADMIN_ROLE)){	
			try{
				Title created = service.createTitle(title);
				response.setStatus(HttpServletResponse.SC_CREATED);
				return created;
			}
			catch(EntityAlreadyExistException e){
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "bulk", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> createTitleCorpus(@RequestBody List<Title> titles, HttpServletResponse response) {
		if(SessionDetails.getUserRole().equals(ADMIN_ROLE)){
			try{
				List<Title> created = service.createTitleCorpus(titles);
				response.setStatus(HttpServletResponse.SC_CREATED);
				return created;
			}
			catch(EntityAlreadyExistException e){
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title updateTitle(@PathVariable("id") String titleId, @RequestBody Title title, HttpServletResponse response) {
		if(SessionDetails.getUserRole().equals(ADMIN_ROLE)){		
			try{
				Title created = service.updateTitle(titleId, title);
				response.setStatus(HttpServletResponse.SC_OK);
				return created;
			}
			catch(EntityNotFoundException e){
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteTitle(@PathVariable("id") String titleId, HttpServletResponse response) {
		if(SessionDetails.getUserRole().equals(ADMIN_ROLE)){
			try{
				response.setStatus(HttpServletResponse.SC_OK);
				service.deleteTitle(titleId);
			}
			catch(EntityNotFoundException e){
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				System.err.println(e.getMessage());
			}
		}
		else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Title findTitle(@PathVariable("id") String titleId, HttpServletResponse response) {
		try{
			return service.findTitle(titleId);
		}
		catch(EntityNotFoundException e){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.err.println(	e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Title> findAllTitles() {
		return service.findAllTitles();
	}

}