package com.booksrecords.demo.MVPBookRecords.Repository;

import com.booksrecords.demo.MVPBookRecords.Entity.Book_Rents;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import com.booksrecords.demo.MVPBookRecords.Entity.People;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.Book_RentsRepo;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.CrudBooksRepo;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.CrudPeopleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookRentsRepoTest {
    private final CrudBooksRepo crudBooksRepo;
    private final CrudPeopleRepo crudPeopleRepo;
    private final Book_RentsRepo bookRentsRepo;

    private List<People> peopleList;
    private List<Books> booksList;

    @Autowired
    public BookRentsRepoTest(CrudBooksRepo crudBooksRepo, CrudPeopleRepo crudPeopleRepo, Book_RentsRepo bookRentsRepo) {
        this.crudBooksRepo = crudBooksRepo;
        this.crudPeopleRepo = crudPeopleRepo;
        this.bookRentsRepo = bookRentsRepo;
    }

    @BeforeEach
    void setUp() {
        peopleList = new ArrayList<>();
        booksList = new ArrayList<>();
        People person1 = new People();
        person1.setName("Edy Kelvianto");
        person1.setUpdatedAt(new Date());
        person1.setCreatedAt(new Date());
        person1.setCountry_id(12);
        peopleList.add(person1);

        People person2 = new People();
        person2.setName("Lim Yang");
        person2.setUpdatedAt(new Date());
        person2.setCreatedAt(new Date());
        person2.setCountry_id(23);
        peopleList.add(person2);


        People person3 = new People();
        person3.setName("John Wick");
        person3.setUpdatedAt(new Date());
        person3.setCreatedAt(new Date());
        person3.setCountry_id(23);
        peopleList.add(person3);

        Books books = new Books();
        books.setName("Hololive Production");
        books.setCreatedAt(new Date());
        books.setUpdatedAt(new Date());
        booksList.add(books);

        Books books2 = new Books();
        books2.setName("Nijisanji");
        books2.setCreatedAt(new Date());
        books2.setUpdatedAt(new Date());
        booksList.add(books2);

        Books books3 = new Books();
        books3.setName("SomeBooks");
        books3.setCreatedAt(new Date());
        books3.setUpdatedAt(new Date());
        booksList.add(books3);



    }

    private void addNewBookRents(People people, Books book, int times) {
        for (int i = 0; i < times; i++) {
            Book_Rents bookRent = new Book_Rents();
            bookRent.setPerson_id(people);
            bookRent.setBook_id(book);
            bookRent.setCreatedAt(new Date());
            bookRent.setUpdatedAt(new Date());
            bookRentsRepo.save(bookRent);
        }
    }

    @Test
    @Transactional
    public void getTopBookBorrowerNamesInCountry() {
        for (int i = 0 ; i< peopleList.size() ; i++){
            crudPeopleRepo.save(peopleList.get(i));
            crudBooksRepo.save(booksList.get(i));
        }

        addNewBookRents(peopleList.get(0), booksList.get(1), 1);
        addNewBookRents(peopleList.get(1), booksList.get(1), 2);
        addNewBookRents(peopleList.get(2), booksList.get(1), 1);

        List<String> names = bookRentsRepo.findTop3Borrower(23, booksList.get(1).getId());
        assertEquals(List.of(peopleList.get(1).getName(), peopleList.get(2).getName()), names);
    }
}
