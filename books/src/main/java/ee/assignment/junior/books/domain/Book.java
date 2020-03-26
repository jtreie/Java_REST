package ee.assignment.junior.books.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @Column(name = "isbn")
    @NotNull
    @Size(max = 13, min = 1)
    private String isbn;
    
    @ManyToOne
    private Rating rating;

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

}
