package com.movieflix.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.movieflix.app.entity.Comment;

public interface CommentRepository {

	public Comment createComment(Comment comment);
	
	public List<Comment> findAllComments(String titleId);

}
