package com.booksrecords.demo.MVPBookRecords.Entity;

import com.booksrecords.demo.MVPBookRecords.Repository.Interface.CrudPeopleRepo;
import com.booksrecords.demo.MVPBookRecords.Util.CountryDataUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PeopleTest {
    private final EntityManager entityManager;
    private final CountryDataUtils countryDataUtils;
    private People people;

    @Autowired
    public PeopleTest(EntityManager entityManager, CountryDataUtils countryDataUtils) {
        this.entityManager = entityManager;
        this.countryDataUtils = countryDataUtils;
    }

    @BeforeEach
    void setUp(){
        people = new People();

        people.setName("Edy Kelvianto");
        people.setUpdatedAt(new Date());
        people.setCreatedAt(new Date());
        people.setCountry_id(702);
    }

    @Test
    @Transactional
    public void Create() {
        assertEquals(0, people.getId());
        entityManager.persist(people);
        entityManager.flush();
        assertNotEquals(0, people.getId());
    }


    @Test
    @Transactional
    public void Update(){
        entityManager.persist(people);
        entityManager.flush();

        People tempPeople = entityManager.find(People.class, people.getId());
        tempPeople.setName("Tweyen");
        tempPeople.setUpdatedAt(new Date());

        entityManager.merge(tempPeople);
        entityManager.flush();
        people = entityManager.find(People.class, tempPeople.getId());
        assertEquals(people, tempPeople );
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
