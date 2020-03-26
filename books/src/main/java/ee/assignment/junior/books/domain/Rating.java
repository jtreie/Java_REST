package ee.assignment.junior.books.domain;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "book_ratings")
public class Rating {

	@Id
    @SequenceGenerator(name = "rating_seq", sequenceName = "rating_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "isbn", nullable = false)
    @NotNull
    @Size(max = 13, min = 1)
    private String isbn;
    
    @OneToMany(mappedBy = "rating")
    private List<Book> books;
    
    @Column(name = "book_rating", nullable = false)
    @NotNull
    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
