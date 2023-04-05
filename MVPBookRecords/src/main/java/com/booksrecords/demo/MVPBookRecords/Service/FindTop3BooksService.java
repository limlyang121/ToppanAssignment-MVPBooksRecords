package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books.Top3BooksDTO;

import java.util.List;

public interface FindTop3BooksService {
    List<Top3BooksDTO> findTop3BooksRented(String country);
}
