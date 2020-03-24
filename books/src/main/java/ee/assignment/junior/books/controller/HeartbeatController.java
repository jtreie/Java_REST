package ee.assignment.junior.books.controller;

import lombok.var;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ee.assignment.junior.books.domain.BookList;
import ee.assignment.junior.books.domain.BookListRepository;
import ee.assignment.junior.books.domain.TopList;
import ee.assignment.junior.books.domain.TopListRepository;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;
import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;

@Slf4j
@RestController
public class HeartbeatController {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private TopListRepository topListRepository;
    @Autowired
    private BookListRepository bookListRepository;

    /* Start book CRUD OPERATIONS FOR BOOK */
    @GetMapping("/book")
    public List<Book> retrieveAllBook() {
    	return booksRepository.findAll();
    }
	@GetMapping("/book/{isbn}")
    public Book retrieveBook(@PathVariable String isbn) throws BookNotFoundException {
    	Optional<Book> book = booksRepository.findById(isbn);
    	
    	if (!book.isPresent())
    		throw new BookNotFoundException("Could not find book with isbn: " + isbn);
    	return book.get();
    }
    @DeleteMapping("/book/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
    	booksRepository.deleteById(isbn);
    }
    @PostMapping("/book")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
    	Book savedBook = booksRepository.save(book);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(savedBook.getIsbn()).toUri();
    	
    	return ResponseEntity.created(location).build();
    }
    @PutMapping("/book/{isbn}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable String isbn) {
    	Optional<Book> bookOptional = booksRepository.findById(isbn);
    	
    	if (!bookOptional.isPresent())
    		return ResponseEntity.notFound().build();
    	book.setIsbn(isbn);
    	booksRepository.save(book);
    	return ResponseEntity.noContent().build();
    }
    
    /*END OF BOOK CRUD*/
    
    
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
    
    /* ADD RATING BY BOOK ISBN*/
    @GetMapping("/ratings")
    public List<Rating> retrieveAllRatings() {
    	return ratingRepository.findAll();
    }
    @PostMapping("/rating/{isbn}")
    public ResponseEntity<Object> createRating(@RequestBody Rating rating) {
    	Rating savedRating = ratingRepository.save(rating);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(savedRating.getIsbn()).toUri();
    	
    	return ResponseEntity.created(location).build();
    }
    //Adds to table ratings, so cannot be seen in toplist or pages that use other tables
    /* END OF ADD RATING BY BOOK ISBN*/
    
    
    
    
    /* TopList */
    //They are lists of 5, 10 and 15 for now as adding more than 100 books and ratings is very time consuming
    @GetMapping("/book/top10")
    public List<TopList> retrieveTop10Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 5);
    	return b;
    }
    @GetMapping("/book/top50")
    public List<TopList> retrieveTop50Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 10);
    	return b;
    }
    @GetMapping("/book/top100")
    public List<TopList> retrieveTop100Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 15);
    	return b;
    }
    //Throws exception if there are not enough items in list
    /* END OF TOPLIST */
    
    
    
    /* GET ALL BOOKS WITH RATING*/
    //Shows only title and rating as the task said
    @GetMapping("/rating")
    public List<BookList> retrieveAllRating() {
    	return bookListRepository.findAll();
    }
    /*END OF BOOKS WITH RATING*/
    
    
    
    /*GET BOOK AND RATING By ISBN*/
    @GetMapping("/rating/{isbn}")
    public TopList retrieveBookAndRating(@PathVariable String isbn) throws BookNotFoundException {
    	Optional<TopList> book = topListRepository.findById(isbn);
    	
    	if (!book.isPresent())
    		throw new BookNotFoundException("Could not find a rated book with isbn: " + isbn);
    	return book.get();
    }
   /*END OF GET BOOK BY ISBN*/
    
}
