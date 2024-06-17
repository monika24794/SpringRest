package movie_api.restcontroller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movie_api.entity.Movie;
import movie_api.exception.MovieNotfoundException;
import movie_api.service.MovieService;
@RestController
public class MovieRestController {
	@Autowired
	private MovieService movieServiceRef;

	// get/movie-api
	@GetMapping("/movie-api")
	public Collection<Movie> retriveAll() {
		Collection<Movie> allmovies = movieServiceRef.retriveAll();
		return allmovies;
	}
	@GetMapping ("/movie-api/{movieId}")
	public Movie retriveOne(@PathVariable   Integer movieId)
	{
		Movie foundmovie=
		movieServiceRef.retriveOne(movieId);
		
		//System.out.println(foundmovie);
	/* if movie s found than return that movie
	 * if not found throw movieNotfoundException
	 */
		if(foundmovie == null) {
		MovieNotfoundException ex = 
		new MovieNotfoundException("The movie with given id is not avliable",movieId);
		}
		
		return foundmovie;
		
		
	}
	//post
	@PostMapping("/movie-api")
	 public void  createNewMovie( @RequestBody  Movie movieRef) 
	 {
		movieServiceRef.createNewMovie(movieRef);
	 }
	//put
	//patch
	@PutMapping("/movie-api")
	 public void updateNewMovie( @RequestBody  Movie updatemovieRef) 
	 {
		movieServiceRef.createNewMovie(updatemovieRef);
	 }
	@PatchMapping("/movie-api")
	 public void updateMoviefiled( @RequestBody  Movie updatemovieRef) 
	 {
		movieServiceRef.createNewMovie(updatemovieRef);
	 }
	@DeleteMapping ("/movie-api/{movieId}")
	public void deleteOne(@PathVariable   Integer movieId)
	 {
		 movieServiceRef.deleteOne(movieId);
	 }
}
