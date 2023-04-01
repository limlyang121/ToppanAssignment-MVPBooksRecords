package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.NoBookResultException;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.AuthorBooksRepo;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.Book_RentsRepo;
import com.booksrecords.demo.MVPBookRecords.Util.CountryDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindTop3BooksServiceImpl implements FindTop3BooksService {
    private Book_RentsRepo bookRentsRepo;
    private AuthorBooksRepo authorBooksRepo;
    private CountryDataUtils countryDataUtils;
    private Test test;

    @Autowired
    public FindTop3BooksServiceImpl(Book_RentsRepo bookRentsRepo, AuthorBooksRepo authorBooksRepo, CountryDataUtils countryDataUtils, Test test) {
        this.bookRentsRepo = bookRentsRepo;
        this.authorBooksRepo = authorBooksRepo;
        this.countryDataUtils = countryDataUtils;
        this.test = test;
    }

    @Override
    @Transactional
    public List<Top3Books> findTop3BooksRented(String country) {
        long countryCode = countryDataUtils.getCountryCode(country);

        List<Books> bookRentsList = bookRentsRepo.findTop3BooksRented();
        if (bookRentsList.isEmpty())
            throw new NoBookResultException("No Results");

        List<Top3Books> top3BooksList = new ArrayList<>(3);

        for (Books books : bookRentsList){
            Top3Books top3Data = new Top3Books();
            top3Data.setName(books.getName());

            Optional<String> authors = authorBooksRepo.findAuthorsByBookID(books.getId());
            if (authors.isPresent()){
                top3Data.setAuthor(authors.get());

                List<String> borrowerList = bookRentsRepo.findTop3Borrower(countryCode, books.getId());
                top3Data.setBorrower(borrowerList);

                top3BooksList.add(top3Data);
            }else {

            }
        }
        return top3BooksList;
    }
}
