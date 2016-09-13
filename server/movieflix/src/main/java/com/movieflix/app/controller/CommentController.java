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
import com.movieflix.app.entity.Comment;
import com.movieflix.app.exception.EntityNotFoundException;
import com.movieflix.app.service.CommentService;

@RestController
@RequestMapping(value = "titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment createComment(@RequestBody Comment comment, HttpServletResponse response) {
		try{
			Comment created = service.createComment(comment);
			response.setStatus(HttpServletResponse.SC_CREATED);
			return created;
		}
		catch(EntityNotFoundException e){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.err.println(e.getMessage());
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.GET, value ="{id}/comments")
	public List<Comment> findAllComments(@PathVariable("id") String titleId) {
		return service.findAllComments(titleId);
	}

}
