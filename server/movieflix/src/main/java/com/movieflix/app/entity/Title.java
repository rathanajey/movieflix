package com.movieflix.app.entity;

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
		@NamedQuery(name = "Title.findOne", query = "SELECT e from Title e WHERE e.id=:pID"),
		@NamedQuery(name = "Title.findByImdbID", query = "SELECT e from Title e where e.imdbID=:pImdbID"),	
		@NamedQuery(name = "Title.findAll", query = "SELECT e from Title e ORDER BY e.imdbID"),
})
public class Title {
	@Id
	private String id;

	private String Title;
	private int Year;
	private String Rated;
	private String Released;
	private String RunTime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private int MetaScore;
	private int imdbVotes;
	private String imdbID;
	private String Type;
	
	@Column(unique = true)
	private float imdbRating;


	public Title() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		this.Year = year;
	}

	public String getRated() {
		return Rated;
	}

	public void setRated(String rated) {
		this.Rated = rated;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		this.Released = released;
	}

	public String getRunTime() {
		return RunTime;
	}

	public void setRunTime(String runTime) {
		this.RunTime = runTime;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		this.Genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		this.Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		this.Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		this.Actors = actors;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		this.Plot = plot;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		this.Language = language;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		this.Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		this.Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		this.Poster = poster;
	}

	public int getMetaScore() {
		return MetaScore;
	}

	public void setMetaScore(int metaScore) {
		this.MetaScore = metaScore;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
}
