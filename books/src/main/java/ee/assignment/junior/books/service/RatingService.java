package ee.assignment.junior.books.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;

@Component
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	@Autowired BooksRepository bookRepository;
	
	public List<Rating> retrieveAllRatings() {
    	return ratingRepository.findAll();
	}
	public Book createRating(String isbn, Rating rating) {
		Book book = bookRepository.getOne(isbn);
		book.setRating(rating);
		return bookRepository.save(book);
    	//Rating savedRating = ratingRepository.save(rating);
    	//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(savedRating.getIsbn()).toUri();
    	//return ResponseEntity.created(location).build();
    }
}
