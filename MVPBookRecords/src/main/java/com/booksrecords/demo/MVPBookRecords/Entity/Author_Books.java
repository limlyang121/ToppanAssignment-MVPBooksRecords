package com.booksrecords.demo.MVPBookRecords.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(name = "author_books",  schema = "public")
@IdClass(Author_BooksID.class)
public class Author_Books {
    @Column(name = "\"createdAt\"")
    private Date createdAt;

    @Column(name = "\"updatedAt\"")
    private Date updatedAt;

    @Id
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors authors_id;

    @Id
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books books_id;

    public Author_Books() {
        authors_id = new Authors();
        books_id = new Books();
    }
}
