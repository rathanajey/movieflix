package com.movieflix.app.service;

import java.util.ArrayList;
import java.util.List;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.entity.Title;

public interface TitleService {
	
	public ArrayList<Title> createTitleCorpus(List<Title> titles);
	
	public Title createTitle(Title title);
	
	public void deleteTitle(String title);
	
	public Title updateTitle(String titleId, Title title);
	
	public List<Title> findAll();
	
	public Title findOne(String titleId);

	public Comment createComment(Comment comment);
	
	public List<Comment> findAllComments(String titleId);

}
