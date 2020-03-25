package ee.assignment.junior.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import ee.assignment.junior.books.domain.TopList;
import ee.assignment.junior.books.service.TopListService;

@RestController
public class TopListController {

    @Autowired
    private TopListService topListService;
   

    /* TopList */
    //They are lists of 5, 10 and 15 for now as adding more than 100 books and ratings is very time consuming
    @GetMapping("/book/top10")
    public List<TopList> retrieveTop10Books() {
    	return topListService.retrieveTop10Books();
    }
    @GetMapping("/book/top50")
    public List<TopList> retrieveTop50Books() {
    	return topListService.retrieveTop50Books();
    }
    @GetMapping("/book/top100")
    public List<TopList> retrieveTop100Books() {
    	return topListService.retrieveTop100Books();
    }
    //Throws exception if there are not enough items in list
    /* END OF TOPLIST */
       
    /*GET BOOK AND RATING By ISBN*/
    @GetMapping("/rating/{isbn}")
    public TopList retrieveBookAndRating(@PathVariable String isbn) throws BookNotFoundException {
    	return topListService.retrieveBookAndRating(isbn);
    }
   /*END OF GET BOOK BY ISBN*/
    
}
