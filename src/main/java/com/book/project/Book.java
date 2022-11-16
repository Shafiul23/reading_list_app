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

    public Book(){

    }

    public Book(String title,
                String author,
                String description,
                boolean read){
        this.title = title;
        this.author = author;
        this.description = description;
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString(){
        return "Book [id=" + id
                + ", title=" + title
                + ", author=" + author
                + ", description=" + description
                + "read= " + read + "]";
    }
}