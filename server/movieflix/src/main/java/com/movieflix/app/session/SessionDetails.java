package com.movieflix.app.session;

import com.movieflix.app.entity.User;

public class SessionDetails {
	
	private static SessionDetails session;
	
	private User user;
	
	public static SessionDetails getSession(){
		return session;
	}
	
	public static void setSession(User user){
		session = new SessionDetails(user);
	}
	
	private SessionDetails(User user){
		this.user = user;
	}
	
	public User getUser(){
		return this.user;
	}

}
