package ee.assignment.junior.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ee.assignment.junior.books.service.BooksService;
import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;

@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	private BooksService booksService;
	@Autowired
    private BooksRepository booksRepository;
	
	/* Start book CRUD OPERATIONS FOR BOOK */
    @GetMapping()
    public List<Book> retrieveAllBook() {
    	return booksService.retrieveAllBooks();
    }
    
	@GetMapping("/{isbn}")
    public Book retrieveBook(@PathVariable String isbn) throws BookNotFoundException {
    	return booksService.retrieveBook(isbn);
    }
	
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
    	booksRepository.deleteById(isbn);
    }
    
    @PostMapping("")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
    	return booksService.createBook(book);
    	
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable String isbn) {
    	return booksService.updateBook(book, isbn);
    }    
    /*END OF BOOK CRUD*/

}
