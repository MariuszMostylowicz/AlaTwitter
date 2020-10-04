package models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @Column(name = "published_at")
    @CreationTimestamp
    private Date publishedAt;

    /*@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_fk")    //Dodaj kolumne*/
    private String author;


    public Tweet() {
    }


    public Tweet(String author, String message ) {
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", publishedAt=" + publishedAt +
                ", author=" + author +
                '}';
    }
}
