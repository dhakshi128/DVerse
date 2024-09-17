package com.project.dverse.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.dverse.ResourceNotFoundException;
import com.project.dverse.entity.MovieEntity;
import com.project.dverse.repo.MovieRepo;
@Service
public class MovieService implements MovieInterface {
	@Autowired
	private MovieRepo movierepo;
	//Create
	@Override
	public MovieEntity createMovie(MovieEntity movie) {
		return movierepo.save(movie);
	}
	//Read
	@Override
	public List<MovieEntity> getAllMovies(){
		return movierepo.findAll();
	}
	//Read by id:
	@Override
	public MovieEntity getMovieById(Long id){
		return movierepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie Not Found"));
	}
	//update
	@Override
	public MovieEntity updateMovie(Long id,MovieEntity movieDetails) {
		MovieEntity movie=movierepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie Not Found"));
		movie.setMovieName(movieDetails.getMovieName());
		movie.setTheatreName(movieDetails.getTheatreName());
		movie.setDate(movieDetails.getDate());
		return movierepo.save(movie);
	}
	//Delete
	@Override
	public void deleteMovie(Long id) {
		MovieEntity movie=movierepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Movie Not Found"));
		movierepo.delete(movie);
	}
	
}
