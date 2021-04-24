package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entity.Movie;
import com.movie.service.MovieService;

@RestController
@CrossOrigin("*")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Okay";
	}
	
	/*
	//Easier traditional method
	//Get a list of all the movies
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return movieService.getAllMovies();
	}
	*/
	
	//Advanced recommended method
	// Get a list of all the movies
	@GetMapping("/movies")
	public ResponseEntity<Object> getAllMovies(){
		return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
	}
	
	/*
	//Add a movie to the database
	@PostMapping("/movies")
	public void addAMovie(@RequestBody Movie movie) {
		movieService.addAMovie(movie);
	}
	*/

	 //Recommended method to add a movie to the database
	 @PostMapping("/movies")
	 public String addAMovie(@RequestBody Movie movie){
		 
		 movieService.addAMovie(movie);
		 return "Record added";
	 }
	
	//Update a movie in the database
	@PutMapping("/movies")
	public void updateAMovie(@RequestBody Movie movie) {
		movieService.updateAMovie(movie);
	}
		
	//Delete a movie from the database
	@DeleteMapping("/movies/{movieId}")
	public void deleteAMovie(@PathVariable int movieId) {
		movieService.deleteAMovie(movieId);
	}
	
}
