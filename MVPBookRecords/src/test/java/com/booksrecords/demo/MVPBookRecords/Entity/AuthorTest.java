package com.booksrecords.demo.MVPBookRecords.Entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AuthorTest {
    private EntityManager entityManager;

    private Authors authors;

    @Autowired
    public AuthorTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setUp() {
        authors = new Authors();
        authors.setName("Anya Melfissa");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
    }

    @Test
    @Transactional
    void Create() {
        assertEquals(0, authors.getId());
        entityManager.persist(authors);
        entityManager.flush();
        assertNotEquals(0, authors.getId());
    }

    @Test
    @Transactional
    void Update() {
        entityManager.persist(authors);
        entityManager.flush();

        Authors tempAuthors = entityManager.find(Authors.class, authors.getId());
        tempAuthors.setName("Mr.Authors");
        tempAuthors.setUpdatedAt(new Date());

        entityManager.merge(tempAuthors);
        entityManager.flush();
        authors = entityManager.find(Authors.class, tempAuthors.getId());
        assertEquals(authors, tempAuthors);
    }

    @Test
    @Transactional
    void Delete() {
        entityManager.persist(authors);
        entityManager.flush();

        Authors tempAuthors = entityManager.find(Authors.class, authors.getId());

        assertNotNull(tempAuthors);

        entityManager.remove(tempAuthors);
        entityManager.flush();

        tempAuthors = entityManager.find(Authors.class, tempAuthors.getId());
        assertNull(tempAuthors);
    }
}
