package com.booksrecords.demo.MVPBookRecords.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GetRandomCountryServiceTest {
    private GetRandomCountryService getRandomCountryService;

    @Autowired
    public GetRandomCountryServiceTest(GetRandomCountryService getRandomCountryService) {
        this.getRandomCountryService = getRandomCountryService;
    }

    @Test
    void GetRandomCountryRun100Times() {
        for (int i = 0 ; i < 100 ; i++){
            assertNotNull(getRandomCountryService.getRandomCountry());
        }
    }
}
