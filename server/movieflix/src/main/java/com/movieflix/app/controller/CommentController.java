package com.movieflix.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.service.CommentService;

@RestController
@RequestMapping(value = "titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment createComment(@RequestBody Comment comment) {
		return service.createComment(comment);
	}

	@RequestMapping(method = RequestMethod.GET, value ="{id}/comments")
	public List<Comment> findAllComments(@PathVariable("id") String titleId) {
		return service.findAllComments(titleId);
	}

}
