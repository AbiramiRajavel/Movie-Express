package com.infy.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> 
{
     Optional<Director> findByFirstName(String Dname);
     
     @Modifying
     @Query("update Director set address=:address where first_Name=:name")
     public void updateDirectordetails(@Param("name") String name,@Param("address") String Daddrss); 
     
    @Query(value="select m from director",nativeQuery=true)
    List<Director> ls();
     
}
