package com.booksrecords.demo.MVPBookRecords.DTO.Top3Books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top3BooksDTO {
    private String author;
    private String name;
    private String[] borrower;

    public void setBorrower(List<String> borrower){
        this.borrower = borrower.toArray(new String[3]);
    }

}
