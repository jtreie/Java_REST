package ee.assignment.junior.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ee.assignment.junior.books.domain.BookList;
import ee.assignment.junior.books.domain.BookListRepository;

@Component
public class BookListService {
	
	@Autowired
	private BookListRepository bookListRepository;
	
	public List<BookList> retrieveAllRating() {
    	return bookListRepository.findAll();
    }
}
