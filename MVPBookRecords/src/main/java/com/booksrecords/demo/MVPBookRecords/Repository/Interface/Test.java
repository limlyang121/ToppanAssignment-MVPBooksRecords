package com.booksrecords.demo.MVPBookRecords.Repository.Interface;

import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Entity.Book_RentsID;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Test extends JpaRepository<Book_Rents, Book_RentsID> {
    @Query("select br.book_id FROM Book_Rents as br GROUP BY br.book_id ORDER BY COUNT(br.book_id) DESC")
    List<Integer> findTop3BooksRented();
}
