package com.movieflix.app.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty(value = "Title")
	private String title;
	
	@JsonProperty(value = "Year")
	private int year;
	
	@JsonProperty(value = "Rated")
	private String rated;
	
	@JsonProperty(value = "Released")
	private String released;
	
	@JsonProperty(value = "Runtime")
	private String runTime;
	
	@JsonProperty(value = "Genre")
	private String genre;
	
	@JsonProperty(value = "Director")
	private String director;
	
	@Lob
	@JsonProperty(value = "Writer")
	private String writer;
	
	@JsonProperty(value = "Actors")
	private String actors;
	
	@Column(length = 3000)
	@JsonProperty(value = "Plot")
	private String plot;
	
	@JsonProperty(value = "Language")
	private String language;
	
	@JsonProperty(value = "Country")
	private String country;
	
	@JsonProperty(value = "Awards")
	private String awards;
	
	@JsonProperty(value = "Poster")
	private String poster;
	
	@JsonProperty(value = "Metascore")
	private int metaScore;
	
	@JsonProperty(value = "imdbVotes")
	private int imdbVotes;
	
	@Column(unique = true)
	@JsonProperty(value = "imdbID")
	private String imdbID;
	
	@JsonProperty(value = "Type")
	private String type;
	
	@JsonProperty(value = "imdbRating")
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
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
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
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	
}
