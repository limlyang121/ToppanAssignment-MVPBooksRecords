package com.booksrecords.demo.MVPBookRecords.Entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookTest {
    private EntityManager entityManager;
    private Books books;

    @Autowired
    public BookTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setUp(){
        books = new Books();
        books.setName("Harry Potter");
        books.setCreatedAt(new Date());
        books.setUpdatedAt(new Date());
    }

    @Test
    @Transactional
    public void Create(){
        assertEquals(0,books.getId());
        entityManager.persist(books);
        entityManager.flush();
        assertNotEquals(0, books.getId());
    }

    @Test
    @Transactional
    public void Update(){
        entityManager.persist(books);
        entityManager.flush();

        Books tempBooks = entityManager.find(Books.class, books.getId());
        tempBooks.setName("Hololive Production");
        tempBooks.setUpdatedAt(new Date());

        entityManager.merge(tempBooks);
        entityManager.flush();
        books = entityManager.find(Books.class, tempBooks.getId());
        assertEquals(books, tempBooks);
    }

    @Test
    @Transactional
    public void Delete(){
        entityManager.persist(books);
        entityManager.flush();

        Books tempBooks = entityManager.find(Books.class, books.getId());
        assertNotNull(tempBooks);

        entityManager.remove(tempBooks);
        entityManager.flush();

        tempBooks = entityManager.find(Books.class, books.getId());
        assertNull(tempBooks);
    }


}
