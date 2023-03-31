package com.booksrecords.demo.MVPBookRecords.Controller;

import com.booksrecords.demo.MVPBookRecords.DTO.Top3Books;
import com.booksrecords.demo.MVPBookRecords.Service.FindTop3BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class Top3GlobalBooksController {
    private final FindTop3BooksService findTop3BooksService;

    public Top3GlobalBooksController(FindTop3BooksService findTop3BooksService) {
        this.findTop3BooksService = findTop3BooksService;
    }

    @GetMapping("getTop3ReadBooks")
    public List<Top3Books> getTop3Books(@RequestParam("country_code") String countryCode){
        List<Top3Books> top3BooksList = findTop3BooksService.findTop3BooksRented(countryCode);


        return top3BooksList;
    }
}
