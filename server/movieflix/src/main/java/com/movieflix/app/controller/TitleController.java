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
import com.movieflix.app.entity.Title;
import com.movieflix.app.service.TitleService;

@RestController
@RequestMapping(value = "titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TitleController {

	@Autowired
	private TitleService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Title> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Title findOne(@PathVariable("id") String titleId) {
		return service.findOne(titleId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="{id}/comments")
	public List<Comment> findAllComments(@PathVariable("id") String titleId) {
		return service.findAllComments(titleId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "bulk", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> createCorpus(@RequestBody List<Title> titles) {
		return service.createTitleCorpus(titles);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title create(@RequestBody Title title) {
		return service.createTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment comment) {
		return service.createComment(comment);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title update(@PathVariable("id") String titleId, @RequestBody Title title) {
		return service.updateTitle(titleId, title);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable("id") String titleId) {
		service.deleteTitle(titleId);
	}
}