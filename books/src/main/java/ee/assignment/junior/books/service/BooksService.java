package ee.assignment.junior.books.service;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ee.assignment.junior.books.controller.BookNotFoundException;
import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;

@Component
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public List<Book> retrieveAllBooks() {
    	return booksRepository.findAll();
	}
	
	public Book retrieveBook(String isbn)  throws BookNotFoundException {
		Optional<Book> book = booksRepository.findById(isbn);
		if (!book.isPresent())
    		throw new BookNotFoundException("Could not find book with isbn: " + isbn);
    	return book.get();
	}
	public ResponseEntity<Object> createBook(Book book) {
    	Book savedBook = booksRepository.save(book);
    	
    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{isbn}").buildAndExpand(savedBook.getIsbn()).toUri();
    	
    	return ResponseEntity.created(location).build();
    }
	public ResponseEntity<Object> updateBook(Book book,String isbn) {
    	Optional<Book> bookOptional = booksRepository.findById(isbn);
    	
    	if (!bookOptional.isPresent())
    		return ResponseEntity.notFound().build();
    	book.setIsbn(isbn);
    	booksRepository.save(book);
    	return ResponseEntity.noContent().build();
    }
}

