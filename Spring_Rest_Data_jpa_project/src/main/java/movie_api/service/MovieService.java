package movie_api.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie_api.entity.Movie;
import movie_api.repository.MovieRepositary;


@Service
public class MovieService {
	@Autowired
	private MovieRepositary movieRepositaryRef;
	
	 public Collection<Movie> retriveAll()
	 {
		Collection<Movie>allMovies= movieRepositaryRef.findAll();
		 return allMovies;
	 }
	 
	 public Movie retriveOne(Integer movieId)
	 {
		 Movie foundMovie=null;
		 Optional<Movie> optionalRef=
		 movieRepositaryRef.findById(movieId);
		 
		 if(optionalRef.isPresent())
			foundMovie = optionalRef.get();
		return foundMovie;
		 
	 }
	 public void  createNewMovie(Movie movieRef) 
	 {
		movieRepositaryRef.save(movieRef);
	}
	 
	 public void  updateMovie(Movie updatemovieRef) 
	 {
		movieRepositaryRef.save(updatemovieRef);
	}
	 public void  updateMoviefiled(Movie updatemovieRef) 
	 {
		movieRepositaryRef.save(updatemovieRef);
	}
	
	 public void deleteOne(Integer movieId)
	 {
		 movieRepositaryRef.deleteById(movieId);
	 }
	
	
}
