package com.booksrecords.demo.MVPBookRecords.Entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class Book_RentsTest {
    private EntityManager entityManager;

    @Autowired
    public Book_RentsTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    @Transactional
    public void AddNullBookOrPeople(){
        People person1 = new People();
        person1.setName("Edy Kelvianto");
        person1.setUpdatedAt(new Date());
        person1.setCreatedAt(new Date());
        person1.setCountry_id(702);
        entityManager.persist(person1);

        Books books1 = new Books();
        books1.setName("Hololive Production");
        books1.setCreatedAt(new Date());
        books1.setUpdatedAt(new Date());
        entityManager.persist(books1);

        Book_Rents bookRents = new Book_Rents();
        bookRents.setBook_id(null);
        bookRents.setPerson_id(person1);
        bookRents.setCreatedAt(new Date());
        bookRents.setUpdatedAt(new Date());

        assertThrows(PersistenceException.class, () -> entityManager.persist(bookRents));

        Book_Rents bookRents1 = new Book_Rents();
        bookRents1.setBook_id(books1);
        bookRents1.setPerson_id(null);
        bookRents1.setCreatedAt(new Date());
        bookRents1.setUpdatedAt(new Date());

        assertThrows(PersistenceException.class, () -> entityManager.persist(bookRents1));

    }
}
