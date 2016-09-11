package com.movieflix.app.service;

import java.util.ArrayList;
import java.util.List;

import com.movieflix.app.entity.Title;

public interface TitleService {
	
	public ArrayList<Title> createTitleCorpus(ArrayList<Title> titleList);
	
	public Title createTitle(Title title);
	
	public void deleteTitle(String title);
	
	public Title updateTitle(String titleId, Title title);
	
	public List<Title> findAll();
	
	public Title findOne(String titleId);

}
