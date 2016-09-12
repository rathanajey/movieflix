package com.movieflix.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movieflix.app.entity.Title;
import com.movieflix.app.service.TitleService;

@RestController
@RequestMapping(value = "titles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TitleController {

	@Autowired
	private TitleService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title createTitle(@RequestBody Title title) {
		return service.createTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "bulk", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> createTitleCorpus(@RequestBody List<Title> titles) {
		return service.createTitleCorpus(titles);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title updateTitle(@PathVariable("id") String titleId, @RequestBody Title title) {
		return service.updateTitle(titleId, title);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void deleteTitle(@PathVariable("id") String titleId) {
		service.deleteTitle(titleId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public Title findTitle(@PathVariable("id") String titleId) {
		return service.findTitle(titleId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Title> findAllTitles() {
		return service.findAllTitles();
	}

}