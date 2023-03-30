package com.booksrecords.demo.MVPBookRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MvpBookRecordsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MvpBookRecordsApplication.class, args);
	}

}
