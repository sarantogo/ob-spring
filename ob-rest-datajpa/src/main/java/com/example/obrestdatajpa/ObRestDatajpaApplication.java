package com.example.obrestdatajpa;

import com.example.obrestdatajpa.models.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		//CRUD

		//Create Book:
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1), true);

		System.out.println("Number of books in Database: "+ bookRepository.count());

		bookRepository.save(book1);
		bookRepository.save(book2);

		System.out.println("Number of books in Database: "+ bookRepository.count());

		/*bookRepository.deleteById(1L);

		System.out.println("Number of books in Database: "+ bookRepository.count());*/

	}

}
