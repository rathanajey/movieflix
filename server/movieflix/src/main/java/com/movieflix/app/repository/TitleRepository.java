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
	
	public Title findTitle(String id);
	
	public List<Title> findAllTitles();
	
}
