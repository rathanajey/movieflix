package com.movieflix.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.entity.Title;
import com.movieflix.app.exception.EntityAlreadyExistException;
import com.movieflix.app.exception.EntityNotFoundException;
import com.movieflix.app.repository.CommentRepository;
import com.movieflix.app.repository.TitleRepository;

@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	TitleRepository titleRepo;
	
	@Autowired
	CommentRepository commentRepo;

	@Transactional
	@Override
	public Title createTitle(Title title) {
		Title existing = titleRepo.findByImdbID(title.getImdbID());
		if(existing != null){
			throw new EntityAlreadyExistException("The Title already exists");
		}
		return titleRepo.createTitle(title);
	}
	
	@Transactional
	@Override
	public ArrayList<Title> createTitleCorpus(List<Title> titleList) {
		ArrayList<Title> created = new ArrayList<Title>();
		
		for(Title title : titleList){
			created.add(createTitle(title));
		}
		
		return created;
	}
	
	@Transactional
	@Override
	public Title updateTitle(String titleId, Title title) {
		Title existing = titleRepo.findTitle(titleId);
		if(existing == null){
			throw new EntityNotFoundException("Title not found");
		}
		return titleRepo.updateTitle(title);
	}

	@Transactional
	@Override
	public void deleteTitle(String titleId) {
		Title existing = titleRepo.findTitle(titleId);
		
		if(existing == null){
			throw new EntityNotFoundException("Title not found");
		}
		
		List<Comment> comments = commentRepo.findAllComments(titleId);
		
		for(Comment c : comments){
			commentRepo.deleteComment(c);
		}
	
		titleRepo.deleteTitle(existing);
	}
	
	@Override
	public Title findTitle(String titleId) {
		Title title = titleRepo.findTitle(titleId);
		if (title == null) {
			throw new EntityNotFoundException("Title not found");
		}
		return title;
	}

	@Override
	public List<Title> findAllTitles() {
		return titleRepo.findAllTitles();
	}

}
