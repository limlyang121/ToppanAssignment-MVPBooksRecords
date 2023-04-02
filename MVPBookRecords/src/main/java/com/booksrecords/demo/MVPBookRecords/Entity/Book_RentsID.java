package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_RentsID implements Serializable {
    private int person_id;
    private int book_id;

    private Date createdAt;
    private Date updatedAt;
}
