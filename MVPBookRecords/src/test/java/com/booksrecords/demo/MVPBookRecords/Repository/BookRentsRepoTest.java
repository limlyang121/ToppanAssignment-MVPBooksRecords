package com.booksrecords.demo.MVPBookRecords.Repository;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books.Top3BooksDTO;
import com.booksrecords.demo.MVPBookRecords.Entity.*;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRentsRepoTest {
    @Autowired
    private CrudBooksRepo crudBooksRepo;
    @Autowired
    private CrudAuthorsRepo crudAuthorsRepo;
    @Autowired
    private CrudPeopleRepo crudPeopleRepo;
    @Autowired
    private AuthorBooksRepo authorBooksRepo;
    @Autowired
    private Book_RentsRepo bookRentsRepo;

    private List<People> peopleList;
    private List<Books> booksList;


    private void addNewBookRents(People people, Books book, int times) {
        for (int i = 0; i < times; i++) {
            Book_Rents bookRent = new Book_Rents();
            bookRent.setPerson_id(people);
            bookRent.setBook_id(book);
            bookRent.setCreatedAt(new Date());
            bookRent.setUpdatedAt(new Date());
            bookRentsRepo.save(bookRent);
            try{
                Thread.sleep(10);
            }catch (InterruptedException e ){
                System.err.println("Need to add little bit of time to avoid Timestamp duplicated");
            }
        }
    }

    @Test
    @Transactional
    public void getTopBookRentedGlobally(){
        People person1 = new People();
        person1.setName("Edy Kelvianto");
        person1.setUpdatedAt(new Date());
        person1.setCreatedAt(new Date());
        person1.setCountry_id(702);
        crudPeopleRepo.save(person1);

        People person2 = new People();
        person2.setName("Lim Yang");
        person2.setUpdatedAt(new Date());
        person2.setCreatedAt(new Date());
        person2.setCountry_id(702);
        crudPeopleRepo.save(person2);

        People person3 = new People();
        person3.setName("Reine Pavolia");
        person3.setUpdatedAt(new Date());
        person3.setCreatedAt(new Date());
        person3.setCountry_id(702);
        crudPeopleRepo.save(person3);

        Authors authors = new Authors();
        authors.setName("John Wick");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
        crudAuthorsRepo.save(authors);

        Books books1 = new Books();
        books1.setName("Hololive Production");
        books1.setCreatedAt(new Date());
        books1.setUpdatedAt(new Date());
        crudBooksRepo.save(books1);


        Books books2 = new Books();
        books2.setName("Nijisanji");
        books2.setCreatedAt(new Date());
        books2.setUpdatedAt(new Date());
        crudBooksRepo.save(books2);


        Books books3 = new Books();
        books3.setName("SomeBooks");
        books3.setCreatedAt(new Date());
        books3.setUpdatedAt(new Date());
        crudBooksRepo.save(books3);


        Books books4 = new Books();
        books4.setName("FourthBooks");
        books4.setCreatedAt(new Date());
        books4.setUpdatedAt(new Date());
        crudBooksRepo.save(books4);

        Books books5 = new Books();
        books5.setName("FifthBook");
        books5.setCreatedAt(new Date());
        books5.setUpdatedAt(new Date());
        crudBooksRepo.save(books5);

        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books1));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books2));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books3));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books4));

        addNewBookRents(person1, books3, 3);
        addNewBookRents(person2, books2, 2);
        addNewBookRents(person3, books1, 5);
        addNewBookRents(person1, books3, 3);
        addNewBookRents(person2, books4, 10);
        addNewBookRents(person3, books5, 1);

        StopWatch stopWatch = new StopWatch();
        //Books 4,3,1
        stopWatch.start();
        List<Books> top3Books = bookRentsRepo.findTop3BooksRented();
        stopWatch.stop();
        System.out.println("Query Execution time is : " + stopWatch.getTotalTimeMillis() + " ms");

        assertEquals(top3Books, List.of(books4, books3, books1));

        addNewBookRents(person2, books5, 12);
        addNewBookRents(person2, books2, 9);

        //Books 5,2,4
        stopWatch.start();
        top3Books = bookRentsRepo.findTop3BooksRented();
        stopWatch.stop();
        System.out.println("Query Execution time is : " + stopWatch.getTotalTimeMillis() + " ms");


        assertNotEquals(top3Books, List.of(books4, books3, books1));
        assertEquals(top3Books, List.of(books5, books2, books4));
    }

    @Test
    @Transactional
    public void getTopBookBorrowerNamesInCountry() {
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

        for (int i = 0 ; i< peopleList.size() ; i++){
            crudPeopleRepo.save(peopleList.get(i));
            crudBooksRepo.save(booksList.get(i));
        }

        addNewBookRents(peopleList.get(0), booksList.get(1), 1);
        addNewBookRents(peopleList.get(1), booksList.get(1), 2);
        addNewBookRents(peopleList.get(2), booksList.get(1), 1);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        List<String> names = bookRentsRepo.findTop3Borrower(23, booksList.get(1).getId());
        stopWatch.stop();
        System.out.println("Query Execution time is : " + stopWatch.getTotalTimeMillis() + " ms");
        assertEquals(List.of(peopleList.get(1).getName(), peopleList.get(2).getName()), names);

        stopWatch.start();
        names = bookRentsRepo.findTop3Borrower(12, booksList.get(1).getId());
        stopWatch.stop();
        System.out.println("Query Execution time is : " + stopWatch.getTotalTimeMillis() + " ms");
        assertEquals(List.of(peopleList.get(0).getName()), names);

        stopWatch.start();
        names = bookRentsRepo.findTop3Borrower(702, booksList.get(1).getId());
        stopWatch.stop();
        System.out.println("Query Execution time is : " + stopWatch.getTotalTimeMillis() + " ms");
        assertEquals(List.of(), names);
    }
}
