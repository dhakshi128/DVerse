package com.project.dverse.service;
import java.util.List;
import com.project.dverse.entity.MovieEntity;

public interface MovieInterface {
    List<MovieEntity> getAllMovies();
    MovieEntity getMovieById(Long id);
    MovieEntity createMovie(MovieEntity movie);
    MovieEntity updateMovie(Long id, MovieEntity movie);
    void deleteMovie(Long id);
}
