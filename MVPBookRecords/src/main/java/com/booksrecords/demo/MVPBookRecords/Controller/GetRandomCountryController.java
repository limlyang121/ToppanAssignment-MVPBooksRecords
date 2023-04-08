package com.booksrecords.demo.MVPBookRecords.Controller;

import com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry.RandomCountryDTO;
import com.booksrecords.demo.MVPBookRecords.Service.GetRandomCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class GetRandomCountryController {
    private final GetRandomCountryService getRandomCountryService;

    @Autowired
    public GetRandomCountryController(GetRandomCountryService getRandomCountryService) {
        this.getRandomCountryService = getRandomCountryService;
    }

    @GetMapping("getRandomCountry")
    public RandomCountryDTO getRandomCountry(){
        return getRandomCountryService.getRandomCountry();
    }
}
