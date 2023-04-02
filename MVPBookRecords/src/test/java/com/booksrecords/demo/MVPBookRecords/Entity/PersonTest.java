package com.booksrecords.demo.MVPBookRecords.Entity;

import com.booksrecords.demo.MVPBookRecords.Repository.Interface.CrudPeopleRepo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonTest {
    private final EntityManager entityManager;
    private final CrudPeopleRepo crudPeopleRepo;
    private People people;

    @Autowired
    public PersonTest(EntityManager entityManager, CrudPeopleRepo crudPeopleRepo) {
        this.entityManager = entityManager;
        this.crudPeopleRepo = crudPeopleRepo;
    }

    @BeforeEach
    void setUp(){
        people = new People();
        People people = new People();

        people.setName("Edy Kelvianto");
        people.setUpdatedAt(new Date());
        people.setCreatedAt(new Date());
        people.setCountry_id(702);
    }

    @Test
    @Transactional
    public void Create() {
        entityManager.persist(people);
        entityManager.flush();
        assertNotNull(people.getId());
    }


    @Test
    @Transactional
    public void Update(){
        entityManager.persist(people);
        entityManager.flush();

        People tempPeople = entityManager.find(People.class, people.getId());
        tempPeople.setName("Tweyen");

        entityManager.merge(tempPeople);
        people = entityManager.find(People.class, tempPeople.getId());
        assertEquals("Tweyen", people.getName());
    }

    @Test
    @Transactional
    public void Delete(){
        entityManager.persist(people);
        entityManager.flush();

        People tempPeople = entityManager.find(People.class, people.getId());

        assertNotNull(tempPeople);

        entityManager.remove(tempPeople);
        entityManager.flush();

        tempPeople = entityManager.find(People.class, people.getId());
        assertNull(tempPeople);
    }

}
