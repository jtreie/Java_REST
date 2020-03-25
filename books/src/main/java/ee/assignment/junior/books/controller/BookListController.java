package ee.assignment.junior.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import ee.assignment.junior.books.domain.BookList;
import ee.assignment.junior.books.service.BookListService;

public class BookListController {
	
	 	@Autowired
	    private BookListService bookListService;
	 
	 	/* GET ALL BOOKS WITH RATING*/
	    //Shows only title and rating as the task said
	    /*END OF BOOKS WITH RATING*/
}
