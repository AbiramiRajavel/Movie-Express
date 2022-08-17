package com.infy.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	
	
	 @Query("select m from Movie m where m.movieTitle=?1")
	 public List<Movie> getDetailsByTitle(String movieName);
	 
	 @Modifying
	 @Query("update Movie m set m.movieRunningTime =:date where m.movieTitle=:mname")
	 public void UpdatemovieReleasedate(@Param("date") Date date,@Param("mname")String mname);
	 
	 public Optional<Movie> findByMovieTitle(String mname);
	 
	 @Query("delete from Movie m where m.movieTitle=?1")
	 @Modifying
	 public void removeMovie(String mname);
}
