package ee.assignment.junior.books.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "isbn")
    @NotNull
    @Size(max = 13, min = 1)
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private String isbn;

    @Column(name = "title", nullable = false)
    @NotNull
    @Size(max = 255, min = 1)
    private String title;

    @Column(name = "author", nullable = false)
    @NotNull
    @Size(max = 255, min = 1)
    private String author;

    @Column(name = "year_of_publication", nullable = false)
    @NotNull
    private int yearOfPublication;

    @Column(name = "publisher")
    @Size(max = 255)
    private String publisher;

	public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
