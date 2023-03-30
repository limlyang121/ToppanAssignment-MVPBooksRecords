package com.booksrecords.demo.MVPBookRecords.Repository.Interface;

import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;

import java.util.List;

public interface Book_RentsRepo {
    List<Book_Rents> findTop3BooksRented();
}
