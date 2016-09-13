package com.movieflix.app.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.entity.Title;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Comment createComment(Comment comment) {
		TypedQuery<Title> query = em.createNamedQuery("Title.findOne", Title.class);
		query.setParameter("pID", comment.getTitleId());
		List<Title> titles = query.getResultList();
		
		if (titles.size() == 1) {
			comment.setTitle(titles.get(0));
			comment.setTitleId(titles.get(0).getId());
		} else {
			throw new EntityNotFoundException("Title does not exist.");
		}
		
		em.persist(comment);
		return comment;
	}

	@Override
	public List<Comment> findAllComments(String titleId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		query.setParameter("pTitleId", titleId);
		List<Comment> comments = query.getResultList();
		return comments;
	}

	@Override
	public void deleteComment(Comment comment) {
		em.remove(comment);
	}
}
