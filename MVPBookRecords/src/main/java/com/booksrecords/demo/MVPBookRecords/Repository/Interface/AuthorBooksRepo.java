package com.booksrecords.demo.MVPBookRecords.Repository.Interface;


import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Authors;

import java.util.Optional;

public interface AuthorBooksRepo {
    Optional<String> findAuthorsByBookID(int bookID);

    Author_Books save(Author_Books authorBooks);

}
