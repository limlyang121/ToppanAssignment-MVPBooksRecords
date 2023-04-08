package com.booksrecords.demo.MVPBookRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MvpBookRecordsApplication {
	public static void main(String[] args) {
		SpringApplication.run(MvpBookRecordsApplication.class, args);
	}

}
