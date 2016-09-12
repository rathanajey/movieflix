package com.movieflix.app.service;

import java.util.List;

import com.movieflix.app.entity.Comment;

public interface CommentService {

	public Comment createComment(Comment comment);
	
	public List<Comment> findAllComments(String titleId);
	
}
