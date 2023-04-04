package com.booksrecords.demo.MVPBookRecords.DTO.RandomCountry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String full_name;
    private String country_code;
}
