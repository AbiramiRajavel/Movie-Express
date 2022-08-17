package com.infy.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.Exception.CustomException;
import com.infy.entity.Director;
import com.infy.entity.Movie;
import com.infy.repository.DirectorRepository;
import com.infy.repository.MovieRepository;

@Service
@Transactional
public class MovieExpressService {
	
	@Autowired
	DirectorRepository directorrepo;
	@Autowired
	MovieRepository movierepo;
	public void InsertMovieAndDirector(Director dir) {
				directorrepo.save(dir);
	}
    public void SearchMovieAndDirectorDetails(String movieTitle) {
    	
    	List<Movie> movie=movierepo.getDetailsByTitle(movieTitle);
		for(Movie movies:movie) {
			System.out.println("Movie name:");
			System.out.println(movies.getMovieTitle());
			Set<Director> dir=movies.getDirector();
			for(Director d:dir) {
				System.out.println("director Details:");
				System.out.print(d);
			}
		}
    }
    public void SearchDirectorMovies(String Dname) throws CustomException {
    	Optional<Director> op=directorrepo.findByFirstName(Dname);	
    	if(op.isPresent())
    		{
    		List<Director> dr=op.stream().collect(Collectors.toList());	
    	for(Director d:dr) {
    		System.out.println("Director name");
    		System.out.println(d.getFirstName());
    		Set<Movie> movies=d.getMovies();
    		for(Movie m:movies) {
    			System.out.println(m);
    		}
    	}}else {
    		throw new CustomException("Record not found");
    	}
    }
    public void SearchfindAllMovies() {
    	List<Movie> movie=movierepo.findAll();
    	for(Movie m:movie) {
    		System.out.println(m.getMovieTitle());
    	}
    }
    
    public void UpdateDirectorDetails(String Dname,String adress) {
    	directorrepo.updateDirectordetails(Dname, adress);
    }
    public void UpdatemovieReleasedate(Date date, String mname) {
    	Optional<Movie> movie=movierepo.findByMovieTitle(mname);
    	movie.ifPresentOrElse(m-> movierepo.UpdatemovieReleasedate(date, mname),()->System.out.println("movie not found"));
    	
    }
    public void removeMovie(String mname) {
    	Optional<Movie> movie=movierepo.findByMovieTitle(mname);
    	movie.ifPresentOrElse(m->movierepo.removeMovie(mname), ()->System.out.println("NOT FOUND"));
    }
    public void dummy() {
    	directorrepo.ls();  
    }
}
