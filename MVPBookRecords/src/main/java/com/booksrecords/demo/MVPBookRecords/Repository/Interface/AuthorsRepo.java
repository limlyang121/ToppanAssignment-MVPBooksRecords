package com.booksrecords.demo.MVPBookRecords.Repository.Interface;

import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Authors;

import java.util.Optional;

public interface AuthorsRepo {
    Optional<Author_Books> findAuthorsByBookID(int bookID);
}
