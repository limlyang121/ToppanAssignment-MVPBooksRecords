package com.booksrecords.demo.MVPBookRecords.Service;

import com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry.RandomCountryDTO;
import com.booksrecords.demo.MVPBookRecords.Util.CountryData;
import com.booksrecords.demo.MVPBookRecords.Util.CountryDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRandomCountryServiceImpl implements GetRandomCountryService{

    private final CountryDataUtils countryDataUtils;

    @Autowired
    public GetRandomCountryServiceImpl(CountryDataUtils countryDataUtils) {
        this.countryDataUtils = countryDataUtils;
    }

    @Override
    public RandomCountryDTO getRandomCountry() {
        CountryData randomCountry = countryDataUtils.getRandomCountry();
        return new RandomCountryDTO(randomCountry);
    }
}
