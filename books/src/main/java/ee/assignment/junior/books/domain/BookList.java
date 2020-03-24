package ee.assignment.junior.books.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_list")
public class BookList {

	@Id
    @Column(name = "title", nullable = false)
    @NotNull
    @Size(max = 255, min = 1)
    private String title;
        
    @Column(name = "book_rating", nullable = false)
    @NotNull
    private int rating;
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}