package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.Book_RentsRepo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FindTop3BooksServiceImpl implements FindTop3BooksService {
    private Book_RentsRepo bookRentsRepo;

    @Override
    @Transactional
    public List<Top3Books> findTop3BooksRented() {
        List<Book_Rents> bookRentsList = bookRentsRepo.findTop3BooksRented();
        System.out.println(bookRentsList);
        return null;
    }
}
