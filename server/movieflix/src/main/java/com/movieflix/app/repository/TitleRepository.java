package com.movieflix.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.entity.Title;

public interface TitleRepository {
	
	public Title updateTitle(Title title);
	
	public void deleteTitle(Title title);
	
	public Title createTitle(Title title);
	
	public Title findByImdbID(String imdbID);
	
	public Title findOne(String id);
	
	public List<Title> findAll();

	public Comment createComment(Comment comment);
	
	public List<Comment> findAllComments(String titleId);
	
}
