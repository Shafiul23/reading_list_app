package com.book.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(
//			BookRepository repository, MongoTemplate mongoTemplate){
//		return args -> {
//			String title = "A Game of Thrones";
//			Book book = new Book(
//					"A Clash of Kings",
//					"George R. R. Martin",
//					"Second book in a Song of Ice and Fire series",
//					true
//			);
//			if(repository.findBookByTitle(book.getTitle()).isPresent()){
//				System.out.println(book + "already in list");
//			} else {
//				System.out.println("Inserting book" + book);
//				repository.insert(book);
//			}
//		};
//	}
}
