package com.booksrecords.demo.MVPBookRecords.Repository.Implimentations;

import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.Book_RentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class Book_RentsRepoImpl implements Book_RentsRepo {
    private EntityManager entityManager;

    @Autowired
    public Book_RentsRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book_Rents> findTop3BooksRented() {
        Query query = entityManager.createQuery("Select br From Book_Rents as br " +
                "group by br.book_id " +
                "order by COUNT (br.book_id) desc " +
                "limit 3");
        return  query.getResultList();
    }
}
