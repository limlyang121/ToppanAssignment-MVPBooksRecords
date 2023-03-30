package com.booksrecords.demo.MVPBookRecords.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top3Books {
    private String author;
    private String name;
    private String[] borrower;

}
