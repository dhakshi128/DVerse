package com.project.dverse.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.dverse.entity.MovieEntity;
import com.project.dverse.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Movie management APIs")
public class MovieController {
	@Autowired
	private MovieService movieservice;
	//create
	@Operation(summary = "Create a new movie", description = "Create a new movie with the provided details")
	@PostMapping
	public ResponseEntity<MovieEntity> createMovie(@RequestBody MovieEntity movie){
		MovieEntity createdmovie=movieservice.createMovie(movie);
		return new ResponseEntity<>(createdmovie,HttpStatus.CREATED);
	}
	//read all
	@Operation(summary = "Get all movies", description = "Retrieve a list of all movies")
	@GetMapping
	public ResponseEntity<List<MovieEntity>> getall(){
		List<MovieEntity> movies=movieservice.getAllMovies();
		return new ResponseEntity<>(movies,HttpStatus.OK);
	}
   //read by id
	@Operation(summary = "Get movie by ID", description = "Retrieve movie details by their ID")
	@GetMapping("/{id}")//http://localhost:8080/movies/1
	public ResponseEntity <MovieEntity>getbyId(@PathVariable Long id){
		MovieEntity movie=movieservice.getMovieById(id);
		return new ResponseEntity<>(movie,HttpStatus.OK);
	}
	//update
	@Operation(summary = "Update movie by ID", description = "Update movie details by their ID")
	@PutMapping("/{id}")
	public ResponseEntity<MovieEntity> updateMovie(@PathVariable Long id,@RequestBody MovieEntity movie){
		MovieEntity movieupdate=movieservice.updateMovie(id, movie);
		return new ResponseEntity<>(movieupdate,HttpStatus.OK);
	}
	//delete
	@Operation(summary = "Delete movie by ID", description = "Delete a movie by their ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletemovie(@PathVariable Long id){
		movieservice.deleteMovie(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
