package com.booksrecords.demo.MVPBookRecords.Repository.Implimentations;

import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Authors;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.AuthorsRepo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class AuthorsRepoImpl implements AuthorsRepo {
    private EntityManager entityManager;

    @Override
    public Optional<Author_Books> findAuthorsByBookID(int bookID) {
        Query query = entityManager.createQuery("From Author_Books where books_id = :bookID");
        query.setParameter("bookID", bookID);
        return Optional.empty();
    }
}
