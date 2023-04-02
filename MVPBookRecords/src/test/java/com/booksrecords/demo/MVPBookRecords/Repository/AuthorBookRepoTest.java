package com.booksrecords.demo.MVPBookRecords.Repository;

import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Authors;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional

public class AuthorBookRepoTest {

    private final CrudBooksRepo crudBooksRepo;
    private final CrudAuthorsRepo crudAuthorsRepo;
    private final AuthorBooksRepo authorBooksRepo;

    private Books books;
    private Authors authors;

    @Autowired
    public AuthorBookRepoTest(CrudBooksRepo crudBooksRepo, CrudAuthorsRepo crudAuthorsRepo, AuthorBooksRepo authorBooksRepo) {
        this.crudBooksRepo = crudBooksRepo;
        this.crudAuthorsRepo = crudAuthorsRepo;
        this.authorBooksRepo = authorBooksRepo;
    }

    @BeforeEach
    void setUp(){
        books = new Books();
        books.setName("Hololive Production");
        books.setCreatedAt(new Date());
        books.setUpdatedAt(new Date());
        crudBooksRepo.save(books);

        authors = new Authors();
        authors.setName("Anya Melfissa");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
        crudAuthorsRepo.save(authors);

        Author_Books authorBooks = new Author_Books();
        authorBooks.setAuthors_id(authors);
        authorBooks.setBooks_id(books);
        authorBooks.setCreatedAt(new Date());
        authorBooks.setUpdatedAt(new Date());

        authorBooksRepo.save(authorBooks);

    }


    @Test
    public void getAuthorNameFromBookIDPositive(){
        assertEquals( authorBooksRepo.findAuthorsByBookID(books.getId()).get()  , authors.getName());
    }

    @Test
    public void getAuthorNameFromBookIDNegative(){
        assertTrue(authorBooksRepo.findAuthorsByBookID(9999).isEmpty());
    }
}
