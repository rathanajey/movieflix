package com.movieflix.app.session;

import com.movieflix.app.entity.User;

public class SessionDetails {
	
	private static SessionDetails session;
	
	private User user;
	
	private SessionDetails(User user){
		this.user = user;
	}
	
	public static String getUserRole(){
		return session.getUser().getRole();
	}
	
	public static SessionDetails getSession(){
		return session;
	}
	
	public static void setSession(User user){
		session = new SessionDetails(user);
	}
	
	public User getUser(){
		return this.user;
	}

}
