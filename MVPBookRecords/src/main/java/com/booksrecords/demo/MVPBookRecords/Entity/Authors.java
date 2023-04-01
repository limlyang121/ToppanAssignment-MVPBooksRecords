package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table (name = "authors",  schema = "public")
@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "createdAt")
    private Date createdAt;
    @Column(name = "updatedAt")
    private Date updatedAt;

}
