package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_RentsID implements Serializable {
    private int person_id;
    private int book_id;
}
