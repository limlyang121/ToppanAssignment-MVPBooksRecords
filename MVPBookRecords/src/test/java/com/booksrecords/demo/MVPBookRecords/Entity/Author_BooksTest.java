package com.booksrecords.demo.MVPBookRecords.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Author_BooksTest {
    private EntityManager entityManager;

    @Autowired
    public Author_BooksTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    @Transactional
    public void deletingBookAffectAuthorsBook(){
        Authors authors = new Authors();
        authors.setName("John Wick");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
        entityManager.persist(authors);

        Books books1 = new Books();
        books1.setName("Hololive Production");
        books1.setCreatedAt(new Date());
        books1.setUpdatedAt(new Date());
        entityManager.persist(books1);

        Author_Books authorBooks = new Author_Books();
        authorBooks.setAuthors_id(authors);
        authorBooks.setBooks_id(books1);
        authorBooks.setUpdatedAt(new Date());
        authorBooks.setCreatedAt(new Date());

        entityManager.persist(authorBooks);
        entityManager.flush();

        Query query = entityManager.createQuery("delete  from Books  where id=:bookID");
        query.setParameter("bookID", books1.getId());
        query.executeUpdate();

        assertEquals(0 , entityManager.createQuery("from Books ").getResultList().size());
        assertEquals(0 , entityManager.createQuery("from Author_Books ").getResultList().size());
    }

    @Test
    @Transactional
    public void deletingBookRentWillNotAffectBooks(){
        Authors authors = new Authors();
        authors.setName("John Wick");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
        entityManager.persist(authors);

        Books books1 = new Books();
        books1.setName("Hololive Production");
        books1.setCreatedAt(new Date());
        books1.setUpdatedAt(new Date());
        entityManager.persist(books1);

        Author_Books authorBooks = new Author_Books();
        authorBooks.setAuthors_id(authors);
        authorBooks.setBooks_id(books1);
        authorBooks.setUpdatedAt(new Date());
        authorBooks.setCreatedAt(new Date());

        entityManager.persist(authorBooks);
        entityManager.flush();

        Query query = entityManager.createQuery("delete from Author_Books as br where br.books_id.id = :bookID and authors_id.id = :authorID");
        query.setParameter("bookID", books1.getId());
        query.setParameter("authorID", authors.getId());
        query.executeUpdate();

        assertEquals(1 , entityManager.createQuery("from Books ").getResultList().size());
        assertEquals(1 , entityManager.createQuery("from Authors ").getResultList().size());
    }

    @Test
    @Transactional
    public void AddNullAuthorAndBooks(){
        Author_Books authorBooks = new Author_Books();
        authorBooks.setAuthors_id(null);
        authorBooks.setBooks_id(null);
        authorBooks.setUpdatedAt(new Date());
        authorBooks.setCreatedAt(new Date());

        assertThrows(PersistenceException.class, () -> entityManager.persist(authorBooks));
    }

}
