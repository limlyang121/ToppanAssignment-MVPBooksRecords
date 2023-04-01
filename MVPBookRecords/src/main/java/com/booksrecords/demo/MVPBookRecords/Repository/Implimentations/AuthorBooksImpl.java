package com.booksrecords.demo.MVPBookRecords.Repository.Implimentations;

import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Authors;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.AuthorBooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorBooksImpl implements AuthorBooksRepo {
    private EntityManager entityManager;

    @Autowired
    public AuthorBooksImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<String> findAuthorsByBookID(int bookID) {
        Query query = entityManager.createQuery("Select authors_id.name From Author_Books where books_id.id = :bookID");
        query.setParameter("bookID", bookID);
        List<String> authorsList = query.getResultList();
        if (authorsList.isEmpty()){
            return Optional.empty();
        }else
            return Optional.of(authorsList.get(0));
    }

    @Override
    public Author_Books save(Author_Books authorBooks) {
        try{
            entityManager.merge(authorBooks);
            return authorBooks;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
