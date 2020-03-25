package ee.assignment.junior.books.controller;


import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ee.assignment.junior.books.service.BookListService;
import ee.assignment.junior.books.service.RatingService;
import ee.assignment.junior.books.domain.BookList;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;


@RestController("rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired BookListService bookListService;
	/* ADD RATING BY BOOK ISBN*/
	@GetMapping() 
    public List<Rating> retrieveAllRatings() {
    	return ratingService.retrieveAllRatings();
    }
	
	
    @PostMapping("/{isbn}")
    public ResponseEntity<Object> createRating(@RequestBody Rating rating) {
    	return ratingService.createRating(rating);
    }
    
    
    @GetMapping()
    public List<BookList> retrieveAllRating() {
    	return bookListService.retrieveAllRating();
    }
    
    //Adds to table ratings, so cannot be seen in toplist or pages that use other tables
    /* END OF ADD RATING BY BOOK ISBN*/
	
	/* Start Rating*/
    //This part wasn't required by the task
    /*
    
     @GetMapping("/ratings/{id}")
    public Rating retrieveRating(@PathVariable Long id) throws BookNotFoundException {
    	Optional<Rating> rating = ratingRepository.findById(id);
    	
    	if (!rating.isPresent())
    		throw new BookNotFoundException("Could not find a rated book with id: " + id);
    	return rating.get();
    }
    @DeleteMapping("/ratings/{id}")
    public void deleteRating(@PathVariable Long id) {
    	ratingRepository.deleteById(id);
    }
    @PutMapping("/ratings/{id}")
    public ResponseEntity<Object> updateRating(@RequestBody Rating rating, @PathVariable Long id) {
    	Optional<Rating> ratingOptional = ratingRepository.findById(id);
    	
    	if (!ratingOptional.isPresent())
    		return ResponseEntity.notFound().build();
    	rating.setIsbn(id);
    	ratingRepository.save(rating);
    	return ResponseEntity.noContent().build();
    }
    */
}
