package com.book.project;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private boolean read;

    public Book(String title,
                String author,
                String description,
                boolean read){
        this.title = title;
        this.author = author;
        this.description = description;
        this.read = read;
    }
}