package ee.assignment.junior.books.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import ee.assignment.junior.books.service.BookListService;
import ee.assignment.junior.books.service.RatingService;
import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BookList;
import ee.assignment.junior.books.domain.Rating;

@RestController
@RequestMapping("rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired BookListService bookListService;
	/* ADD RATING BY BOOK ISBN*/	
    @PostMapping("/{isbn}")
    public Book createRating(@PathVariable String isbn, @RequestBody Rating rating) {
    	return ratingService.createRating(isbn, rating);
    }
    /* END ADD RATING BY BOOK ISBN*/
    
    
    /* GET ALL BOOKS WITH RATING*/
    //Shows only title and rating as the task said
    @GetMapping()
    public List<BookList> retrieveAllRating() {
    	return bookListService.retrieveAllRating();
    }
    /*END OF BOOKS WITH RATING*/
    
    
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
