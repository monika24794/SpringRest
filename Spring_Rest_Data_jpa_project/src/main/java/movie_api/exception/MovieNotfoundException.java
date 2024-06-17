package movie_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotfoundException extends RuntimeException
{
private Integer invalidMovieId;


public MovieNotfoundException(String errorMassage,
		Integer invalidMovieId) {
	super(errorMassage);
	this.invalidMovieId = invalidMovieId;
}
@Override 
	public String getMessage() {
		String message=super.getMessage();
		String finalMessage= message +"  => "+invalidMovieId;
		
      return finalMessage;
	}

}
