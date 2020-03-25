package ee.assignment.junior.books.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;

@Component
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Rating> retrieveAllRatings() {
    	return ratingRepository.findAll();
	}
	public ResponseEntity<Object> createRating(@RequestBody Rating rating) {
    	Rating savedRating = ratingRepository.save(rating);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(savedRating.getIsbn()).toUri();
    	
    	return ResponseEntity.created(location).build();
    }
}
