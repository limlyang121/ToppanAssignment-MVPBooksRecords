package com.booksrecords.demo.MVPBookRecords.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResponse {

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> notFoundException(CountryNotFoundException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setMessage(exception.getMessage());

        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessage> notFoundException(NoBookResultException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setMessage(exception.getMessage());

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

}
