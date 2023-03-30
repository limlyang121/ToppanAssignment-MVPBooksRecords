package com.booksrecords.demo.MVPBookRecords.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author_BooksID implements Serializable {
    private int authors_id;
    private long books_id;
}
