package com.infy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
public class Director {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long directorId;
   private String firstName;
   private String lastName;
   private String address;
   private String number;
   private String email;
   @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
   @JoinTable(name="fore_id", joinColumns=@JoinColumn(name="directorId"),inverseJoinColumns=@JoinColumn(name="movieId"))
   private Set<Movie> movies;
   public Director() {
	   
   }
public Director(String firstName, String lastName, String address, String number, String email) 
{
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.number = number;
	this.email = email;
}
public Long getDirectorId() {
	return directorId;
}
public void setDirectorId(Long directorId) {
	this.directorId = directorId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Set<Movie> getMovies() {
	return movies;
}
public void setMovies(Set<Movie> movies) {
	this.movies = movies;
}
@Override
public String toString() {
	return "Director [directorId=" + directorId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
			+ address + ", number=" + number + ", email=" + email + "]";
}


   
}
