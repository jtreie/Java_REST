package ee.assignment.junior.books.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import ee.assignment.junior.books.controller.BookNotFoundException;
import ee.assignment.junior.books.domain.TopList;
import ee.assignment.junior.books.domain.TopListRepository;
import lombok.var;

@Component
public class TopListService {

	@Autowired
	private TopListRepository topListRepository;
	
	public List<TopList> retrieveTop10Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 5);
    	return b;
    }
	public List<TopList> retrieveTop50Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 10);
    	return b;
    }
	public List<TopList> retrieveTop100Books() {
    	var a = topListRepository.findAll();
    		var b = a.subList(0, 15);
    	return b;
    }
	public TopList retrieveBookAndRating(@PathVariable String isbn) throws BookNotFoundException {
    	Optional<TopList> book = topListRepository.findById(isbn);
    	
    	if (!book.isPresent())
    		throw new BookNotFoundException("Could not find a rated book with isbn: " + isbn);
    	return book.get();
    }
}