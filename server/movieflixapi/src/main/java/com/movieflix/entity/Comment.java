package com.movieflix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Title.findAll", query = "SELECT e from Title e ORDER BY e.email"),
		@NamedQuery(name = "Title.findByEmail", query = "SELECT e from Title e where e.email=:pEmail")
})
public class Comment {
	@Id
	private String id;

	private String titleID;
	private String userID;
	private String comment;
	private String timeStamp;
	
	public Comment() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public String getTitleID() {
		return titleID;
	}
	public void setTitleID(String titleID) {
		this.titleID = titleID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
