package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dtos.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	@Query(nativeQuery = true, value = "SELECT m.id, m.name "
			+ "FROM movies m "
			+ "INNER JOIN genres g ON m.id_genres = g.id "
			+ "WHERE UPPER(g.description) = UPPER(:genreName);")
	List<MovieMinProjection> search1(String genreName);

	@Query("SELECT new com.devsuperior.uri2611.dtos.MovieMinDTO(obj) "
			+ "FROM Movie obj "
			+ "WHERE UPPER(obj.genre.description) = UPPER(:genreName)")
	List<MovieMinDTO> search2(String genreName);
	
}
