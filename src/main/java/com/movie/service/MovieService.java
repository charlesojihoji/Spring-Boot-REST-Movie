package com.movie.service;

import java.util.List;

import com.movie.entity.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();
	public void addAMovie(Movie movie);
	public void updateAMovie(Movie movie);
	public void deleteAMovie(int movieId);
}
