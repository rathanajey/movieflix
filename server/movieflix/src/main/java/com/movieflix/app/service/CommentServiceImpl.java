package com.movieflix.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.repository.CommentRepository;
import com.movieflix.app.session.SessionDetails;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository repository;
	
	@Transactional
	@Override
	public Comment createComment(Comment comment) {
		comment.setUserID(SessionDetails.getSession().getUser().getId());
		comment.setTimeStamp(new Date().toString());
		
		return repository.createComment(comment);
	}

	@Override
	public List<Comment> findAllComments(String titleId) {
		return repository.findAllComments(titleId);
	}
	
}
