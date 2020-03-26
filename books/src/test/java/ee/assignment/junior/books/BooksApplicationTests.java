package ee.assignment.junior.books;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ee.assignment.junior.books.domain.Book;
import ee.assignment.junior.books.domain.BooksRepository;
import ee.assignment.junior.books.domain.Rating;
import ee.assignment.junior.books.domain.RatingRepository;
import lombok.var;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = BooksApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BooksApplicationTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired private BooksRepository booksRepository;
	@Autowired private RatingRepository ratingRepository;
	//@LocalServerPort
	//private int port;
	//@Resource 
	//private BooksRepository bookRepository;
	//@Resource private RatingRepository ratingRepo;
	//TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test 
	public void whenFindAll() {
		Book firstBook = new Book();
		firstBook.setAuthor("Oskar Luts");
		entityManager.persist(firstBook);
		entityManager.flush();
		
		Book secondBook = new Book();
		secondBook.setAuthor("A. H. Tammsaare");
		entityManager.persist(secondBook);
		entityManager.flush();
		
		List<Book> books = booksRepository.findAll();
		
		assertThat(books.size()).isEqualTo(15);
		assertThat(books.get(6)).isEqualTo(firstBook);
		assertThat(books.get(13)).isEqualTo(secondBook);
	}
	@Test
	public void whenFindById() {
	       //given
	       Book books = new Book();
	       books.setTitle("The Hobbit");
	       entityManager.persist(books);
	       entityManager.flush();

	       //when
	       Optional<Book> testbook = booksRepository.findById(books.getIsbn());

	       //then
	       assertThat(testbook.get().getTitle()).isEqualTo(books.getTitle());
	}
	@Test 
	public void whenFindAllRatings() {
		Rating firstRating = new Rating();
		firstRating.setRating(5);
		entityManager.persist(firstRating);
		entityManager.flush();
		
		Rating secondRating = new Rating();
		secondRating.setRating(10);
		entityManager.persist(secondRating);
		entityManager.flush();
		
		List<Rating> ratings = ratingRepository.findAll();
		
		assertThat(ratings.size()).isEqualTo(12);
		assertThat(ratings.get(10)).isEqualTo(firstRating);
		assertThat(ratings.get(7)).isEqualTo(secondRating);
	}
	@Test
	public void whenFindRatingById() {
	       //given
	       Rating rating = new Rating();
	       rating.setRating(9);
	       entityManager.persist(rating);
	       entityManager.flush();

	       //when
	       Optional<Rating> testRating = ratingRepository.findById(rating.getIsbn());

	       //then
	       assertThat(testRating.get().getRating()).isEqualTo(rating.getRating());
	}
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
