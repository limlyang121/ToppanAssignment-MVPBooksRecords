package com.booksrecords.demo.MVPBookRecords.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "author_books")
@IdClass(Author_BooksID.class)
public class Author_Books {
    private Date createdAt;
    private Date updatedAt;

    @Id
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors authors_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books_id;

    public Author_Books() {
        authors_id = new Authors();
        books_id = new Books();
    }
}
