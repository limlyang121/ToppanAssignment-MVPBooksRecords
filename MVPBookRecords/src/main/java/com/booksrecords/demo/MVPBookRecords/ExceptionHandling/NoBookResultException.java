package com.booksrecords.demo.MVPBookRecords.ExceptionHandling;

public class NoBookResultException extends RuntimeException{
    public NoBookResultException(String message) {
        super(message);
    }
}
