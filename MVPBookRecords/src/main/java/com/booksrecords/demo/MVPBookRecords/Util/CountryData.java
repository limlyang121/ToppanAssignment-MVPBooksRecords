package com.booksrecords.demo.MVPBookRecords.Util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CountryData {
    private String countryName;
    private String shortName;
    private long countryCode;

}
