package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;


@Data
@Entity
@Table(name = "book_rents")
@IdClass(Book_RentsID.class)
public class Book_Rents {
    @Id
    @ManyToOne
    @JoinColumn(name = "people", referencedColumnName = "id")
    private People person_id;
    @Id
    @ManyToOne
    @JoinColumn(name = "books", referencedColumnName = "id")
    private Books book_id;

    private Date createdAt;
    private Date updatedAt;

    public Book_Rents() {
        person_id = new People();
        book_id = new Books();
    }
}
