package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books;

import java.util.List;

public interface FindTop3BooksService {
    List<Top3Books> findTop3BooksRented();
}
