package com.movieflix.app.repository;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.movieflix.app.entity.Comment;
import com.movieflix.app.entity.Title;
import com.movieflix.app.entity.User;
import com.movieflix.app.session.SessionDetails;

@Repository
public class TitleRepositoryImpl implements TitleRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Title updateTitle(Title title) {
		return em.merge(title);
	}

	@Override
	public void deleteTitle(Title title) {
		em.remove(title);
	}

	@Override
	public Title createTitle(Title title) {
		em.persist(title);
		return title;
	}

	@Override
	public Title findByImdbID(String imdbID) {
		TypedQuery<Title> query = em.createNamedQuery("Title.findByImdbID", Title.class);
		query.setParameter("pImdbID", imdbID);
		List<Title> titles = query.getResultList();
		if (titles.size() == 1) {
			return titles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Title findOne(String id) {
		return em.find(Title.class, id);
	}

	@Override
	public List<Title> findAll() {
		TypedQuery<Title> query = em.createNamedQuery("Title.findAll", Title.class);
		return query.getResultList();

	}

	@Override
	public Comment createComment(Comment comment) {
		comment.setUserID(SessionDetails.getSession().getUser().getId());
		comment.setTimeStamp(new Date().toString());
		
		TypedQuery<Title> query = em.createNamedQuery("Title.findOne", Title.class);
		query.setParameter("pID", comment.getTitleId());
		List<Title> titles = query.getResultList();
		
		if (titles.size() == 1) {
			comment.setTitle(titles.get(0));
			comment.setTitleId(titles.get(0).getId());
		} else {
			throw new EntityNotFoundException();
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
}
