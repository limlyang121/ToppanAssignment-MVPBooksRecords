package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "book_rents",  schema = "public")
@IdClass(Book_RentsID.class)
public class Book_Rents {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private People person_id;
    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books book_id;

    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;

    public Book_Rents() {
        person_id = new People();
        book_id = new Books();
    }
}
