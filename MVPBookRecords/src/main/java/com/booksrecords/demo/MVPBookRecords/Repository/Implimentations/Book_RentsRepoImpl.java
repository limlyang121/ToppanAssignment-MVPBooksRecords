package com.booksrecords.demo.MVPBookRecords.Repository.Implimentations;

import com.booksrecords.demo.MVPBookRecords.Entity.Author_Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import com.booksrecords.demo.MVPBookRecords.Entity.People;
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
    public List<Books> findTop3BooksRented() {
        Query query = entityManager.createQuery("SELECT b from Books as b " +
                "join Book_Rents br on b.id = br.book_id.id " +
                "group by b.id, b.name " +
                "order by count (br.book_id) desc");

//        Query query = entityManager.createQuery("SELECT br.book_id from Book_Rents as br " +
//                "group by br.book_id.id " +
//                "order by count (br.book_id.id) desc");
//

        query.setMaxResults(3);
        return  query.getResultList();
    }

    @Override
    public List<String> findTop3Borrower(long countryCode, int bookID) {
        Query query = entityManager.createQuery("select p.name From Book_Rents  as br " +
                        "left outer join People as p on br.person_id.id = p.id " +
                        "where p.country_id = :countryID and br.book_id.id = :bookID " +
                        "group by br.person_id, p.name order by count (br.person_id) desc")
                .setParameter("countryID", countryCode)
                .setParameter("bookID", bookID)
                .setMaxResults(3);


        return query.getResultList();
    }

    @Override
    public Book_Rents save(Book_Rents bookRents) {
        try {
            entityManager.persist(bookRents);
            return bookRents;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
