package com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry;

import com.booksrecords.demo.MVPBookRecords.Util.CountryData;
import lombok.Data;

@Data
public class RandomCountryDTO {
    private Country country;

    public RandomCountryDTO() {
        country = new Country();
    }

    public RandomCountryDTO(CountryData countryData) {
        country = new Country();
        country.setFull_name(countryData.getCountryName());
        country.setCountry_code(String.valueOf(countryData.getCountryCode()));
    }
}
