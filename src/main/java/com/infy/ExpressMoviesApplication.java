package com.infy;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.entity.Director;
import com.infy.entity.Movie;
import com.infy.service.MovieExpressService;

@SpringBootApplication
public class ExpressMoviesApplication implements CommandLineRunner {

	@Autowired
	private MovieExpressService service;
	public static void main(String[] args) {
		SpringApplication.run(ExpressMoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat datetimeformat=new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		Director d1=new Director("Atlee","Kumar","chennai","987654321","atlee@gmail.com");
		Movie m1=new Movie("Beast",dateformat.parse("23/12/2021"),datetimeformat.parse("23/12/2021 2:60:22"));
		Movie m2=new Movie("Raja Rani",dateformat.parse("03/12/2006"),datetimeformat.parse("03/12/2006 2:60:22"));
	   Set<Movie> ms=new HashSet<>();
	   ms.add(m1); ms.add(m2);
		d1.setMovies(ms);
//		service.InsertMovieAndDirector(d1);
//	
//		service.SearchMovieAndDirectorDetails("Raja Rani");
//		service.SearchDirectorMovies("aTlee");
//		service.SearchfindAllMovies();
		service.UpdateDirectorDetails("Atlee", "delhi");
//		service.UpdatemovieReleasedate(datetimeformat.parse("12/11/2000 07:30:22"), "Best");
//	    service.removeMovie("Beast");
	}

}

