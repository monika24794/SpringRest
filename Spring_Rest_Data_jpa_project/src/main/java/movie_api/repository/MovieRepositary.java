package movie_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie_api.entity.Movie;
//@Repository
public interface MovieRepositary extends JpaRepository<Movie, Integer> {}
/* no further code for persistency.
it is managead internally
however, if any further customization is requiread*/