package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books.Top3BooksDTO;
import com.booksrecords.demo.MVPBookRecords.Entity.*;
import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.CountryNotFoundException;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class FindTop3BooksServiceTest {
    private final CrudBooksRepo crudBooksRepo;
    private final CrudAuthorsRepo crudAuthorsRepo;
    private final AuthorBooksRepo authorBooksRepo;
    private final Book_RentsRepo bookRentsRepo;
    private final CrudPeopleRepo crudPeopleRepo;
    private final FindTop3BooksService findTop3BooksService;

    private List<People> peopleList;
    private List<Books> booksList;
    private Authors authors;

    @Autowired
    public FindTop3BooksServiceTest(CrudBooksRepo crudBooksRepo, CrudAuthorsRepo crudAuthorsRepo, AuthorBooksRepo authorBooksRepo, Book_RentsRepo bookRentsRepo, CrudPeopleRepo crudPeopleRepo, FindTop3BooksService findTop3BooksService) {
        this.crudBooksRepo = crudBooksRepo;
        this.crudAuthorsRepo = crudAuthorsRepo;
        this.authorBooksRepo = authorBooksRepo;
        this.bookRentsRepo = bookRentsRepo;
        this.crudPeopleRepo = crudPeopleRepo;
        this.findTop3BooksService = findTop3BooksService;
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
    public void findTop3BooksPositive(){
        peopleList = new ArrayList<>();
        booksList = new ArrayList<>();
        authors = new Authors();

        People person1 = new People();
        person1.setName("Edy Kelvianto");
        person1.setUpdatedAt(new Date());
        person1.setCreatedAt(new Date());
        person1.setCountry_id(702);
        peopleList.add(person1);
        crudPeopleRepo.save(person1);

        People person2 = new People();
        person2.setName("Lim Yang");
        person2.setUpdatedAt(new Date());
        person2.setCreatedAt(new Date());
        person2.setCountry_id(702);
        peopleList.add(person2);
        crudPeopleRepo.save(person2);


        People person3 = new People();
        person3.setName("Reine Pavolia");
        person3.setUpdatedAt(new Date());
        person3.setCreatedAt(new Date());
        person3.setCountry_id(702);
        peopleList.add(person3);
        crudPeopleRepo.save(person3);

        authors = new Authors();
        authors.setName("John Wick");
        authors.setUpdatedAt(new Date());
        authors.setCreatedAt(new Date());
        crudAuthorsRepo.save(authors);

        Books books1 = new Books();
        books1.setName("Hololive Production");
        books1.setCreatedAt(new Date());
        books1.setUpdatedAt(new Date());
        booksList.add(books1);
        crudBooksRepo.save(books1);


        Books books2 = new Books();
        books2.setName("Nijisanji");
        books2.setCreatedAt(new Date());
        books2.setUpdatedAt(new Date());
        booksList.add(books2);
        crudBooksRepo.save(books2);


        Books books3 = new Books();
        books3.setName("SomeBooks");
        books3.setCreatedAt(new Date());
        books3.setUpdatedAt(new Date());
        booksList.add(books3);
        crudBooksRepo.save(books3);


        Books books4 = new Books();
        books4.setName("FourthBooks");
        books4.setCreatedAt(new Date());
        books4.setUpdatedAt(new Date());
        booksList.add(books4);
        crudBooksRepo.save(books4);


        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books1));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books2));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books3));
        authorBooksRepo.save(new Author_Books(new Date(), new Date(), authors, books4));


        addNewBookRents(person1, books3, 3);
        addNewBookRents(person2, books2, 2);
        addNewBookRents(person3, books1, 5);
        addNewBookRents(person1, books3, 3);
        addNewBookRents(person2, books4, 10);


        List<Top3BooksDTO> top3Books = findTop3BooksService.findTop3BooksRented("SG");
        assertTrue(top3Books.size() == 3);
    }

    @Test
    public void findTop3BooksNegative(){
        assertThrows(CountryNotFoundException.class, () -> findTop3BooksService.findTop3BooksRented("ASDASD"));
    }
}
