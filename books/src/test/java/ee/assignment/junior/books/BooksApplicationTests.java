package ee.assignment.junior.books;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;
import lombok.var;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BooksApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksApplicationTests {

	@LocalServerPort
	private int port;
	@Resource 
	private BooksRepository bookRepository;
	@Resource private RatingRepository ratingRepo;
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	
	/*@Test
	public void testGetBooks() throws JSONException {HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	ResponseEntity<String> response = restTemplate.exchange(
			createURLWithPort("/book/0195153448"),
			HttpMethod.GET, entity, String.class);
	
	Book expected = {"0195153448","Classical Mythology","Mark P. O. Morford",2002,"Oxford University Press"};

	JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
	return "http://localhost:" + port + uri;
	}
	
	@Test
    public void givenBook_whenSave_thenGetOk() {
		Book book = new Book("0195153448","","", 1, "");
        bookRepository.save(book);
   
		Book book2 = bookRepository.findOne(isbn);
        assertEquals("Classical Mythology", book2.getTitle());
    }
	@Test
	public void given_rating_whenSave_thenGetOk() {
		Rating rating = new Rating("0195153448",6);
		ratingRepo.save(rating);
		Rating rating2 = ratingRepo.findOne(id);
		assertEquals("");
	}*/
	
	
}
