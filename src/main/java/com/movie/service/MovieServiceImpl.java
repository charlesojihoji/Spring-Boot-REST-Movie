package com.movie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;


@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getAllMovies() {
		
		Iterable<Movie> itr = movieRepository.findAll();
		List<Movie> movies = new ArrayList<>();
		
		for(Movie movie: itr) {
			movies.add(movie);
		}
		
		return movies;
	}
	
	@Override
	public void addAMovie(Movie movie) {
		
		movieRepository.save(movie);
		
	}

	@Override
	public void updateAMovie(Movie movie) {
		
		movieRepository.save(movie);
	}

	@Override
	public void deleteAMovie(int movieId) {
		
		movieRepository.deleteById(movieId);
	}

}
