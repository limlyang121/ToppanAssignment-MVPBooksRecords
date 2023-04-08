package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books.Top3BooksDTO;
import com.booksrecords.demo.MVPBookRecords.Entity.Books;
import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.CountryNotFoundException;
import com.booksrecords.demo.MVPBookRecords.ExceptionHandling.NoBookResultException;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.AuthorBooksRepo;
import com.booksrecords.demo.MVPBookRecords.Repository.Interface.Book_RentsRepo;
import com.booksrecords.demo.MVPBookRecords.Util.CountryDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FindTop3BooksServiceImpl implements FindTop3BooksService {
    private final Book_RentsRepo bookRentsRepo;
    private final AuthorBooksRepo authorBooksRepo;
    private final CountryDataUtils countryDataUtils;

    @Autowired
    public FindTop3BooksServiceImpl(Book_RentsRepo bookRentsRepo, AuthorBooksRepo authorBooksRepo, CountryDataUtils countryDataUtils) {
        this.bookRentsRepo = bookRentsRepo;
        this.authorBooksRepo = authorBooksRepo;
        this.countryDataUtils = countryDataUtils;
    }

    @Override
    @Transactional
    @Cacheable("findTop3BooksRented")
    public List<Top3BooksDTO> findTop3BooksRented(String country) {
        long countryCode = countryDataUtils.getCountryCode(country);
        if (countryCode == 0){
            throw new CountryNotFoundException("Invalid Parameter");
        }

        List<Books> bookRentsList = bookRentsRepo.findTop3BooksRented();
        if (bookRentsList.isEmpty())
            throw new NoBookResultException("No Results");

        List<Top3BooksDTO> top3BooksList = new ArrayList<>(3);

        for (Books books : bookRentsList){
            Top3BooksDTO top3Data = new Top3BooksDTO();
            top3Data.setName(books.getName());

            Optional<String> authors = authorBooksRepo.findAuthorsByBookID(books.getId());
            if (authors.isPresent()){
                top3Data.setAuthor(authors.get());

                List<String> borrowerList = bookRentsRepo.findTop3Borrower(countryCode, books.getId());

                top3Data.setBorrower(borrowerList);

                top3BooksList.add(top3Data);
            }
        }
        return top3BooksList;
    }
}
