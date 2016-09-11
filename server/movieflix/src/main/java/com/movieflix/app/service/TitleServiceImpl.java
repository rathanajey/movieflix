package com.movieflix.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.app.entity.Title;
import com.movieflix.app.exception.EntityAlreadyExistException;
import com.movieflix.app.exception.EntityNotFoundException;
import com.movieflix.app.repository.TitleRepository;

@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	TitleRepository repository;

	@Transactional
	@Override
	public ArrayList<Title> createTitleCorpus(ArrayList<Title> titleList) {
		ArrayList<Title> created = new ArrayList<Title>();
		
		for(Title title : titleList){
			created.add(createTitle(title));
		}
		
		return created;
	}

	@Transactional
	@Override
	public Title createTitle(Title title) {
		Title existing = repository.findByImdbID(title.getImdbID());
		if(existing != null){
			throw new EntityAlreadyExistException("The Title already exists");
		}
		return repository.createTitle(title);
	}

	@Transactional
	@Override
	public void deleteTitle(String titleId) {
		Title existing = repository.findOne(titleId);
		if(existing == null){
			throw new EntityNotFoundException("Title not found");
		}
		repository.deleteTitle(existing);
	}

	@Transactional
	@Override
	public Title updateTitle(String titleId, Title title) {
		Title existing = repository.findOne(titleId);
		if(existing == null){
			throw new EntityNotFoundException("Title not found");
		}
		return repository.updateTitle(title);
	}

	@Override
	public List<Title> findAll() {
		return repository.findAll();
	}

	@Override
	public Title findOne(String titleId) {
		Title title = repository.findOne(titleId);
		if (title == null) {
			throw new EntityNotFoundException("Employee not found");
		}
		return title;
	}

}
