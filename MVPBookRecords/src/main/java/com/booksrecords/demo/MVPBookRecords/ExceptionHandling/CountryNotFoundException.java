package com.booksrecords.demo.MVPBookRecords.ExceptionHandling;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String message) {
        super(message);
    }
}
