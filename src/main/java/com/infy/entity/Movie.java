package com.infy.entity;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long movieId;
	private String movieTitle;
	@Temporal(TemporalType.DATE)
	private Date dateReleased;
	@Temporal(TemporalType.TIMESTAMP)
	private Date movieRunningTime;
	@ManyToMany(mappedBy="movies",fetch=FetchType.EAGER)
    private Set<Director> director;
	
	public Movie(String movieTitle, Date dateReleased, Date movieRunningTime) {
		super();
		this.movieTitle = movieTitle;
		this.dateReleased = dateReleased;
		this.movieRunningTime = movieRunningTime;
	}
	public Movie() {
		
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Date getDateReleased() {
		return dateReleased;
	}
	public void setDateReleased(Date dateReleased) {
		this.dateReleased = dateReleased;
	}
	public Date getMovieRunningTime() {
		return movieRunningTime;
	}
	public void setMovieRunningTime(Date movieRunningTime) {
		this.movieRunningTime = movieRunningTime;
	}
	public Set<Director> getDirector() {
		return director;
	}
	public void setDirector(Set<Director> director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", dateReleased=" + dateReleased
				+ ", movieRunningTime=" + movieRunningTime + "]";
	}

	
	
}
