package com.movieflix.app.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Comment.findAll", query = "SELECT e from Comment e WHERE e.title.id =:pTitleId ORDER BY e.timeStamp"),
})
public class Comment {
	
	public Comment(){
		id = UUID.randomUUID().toString();
	}
	
	@Id
	private String id;
	
	private String userID;
	
	@ManyToOne
	private Title title;
	
	private String titleID;
	
	private String commentText;
	
	private String timeStamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleId() {
		return titleID;
	}

	public void setTitleId(String titleId) {
		this.titleID = titleId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
}
