package com.booksrecords.demo.MVPBookRecords.Repository.Interface;

import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;

import java.util.List;

public interface Book_RentsRepo {
    List<Books> findTop3BooksRented();

    List<String> findTop3Borrower(long countryCode, int bookID);

    Book_Rents save(Book_Rents bookRents);
}
