package com.book.project;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
//    Optional<Book> findBookByTitle(String title);
//    List<Book> findBookByTitle(String title);
}
