package com.book.project;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookController.class)
public class BookControllerTests {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateBook() throws Exception {
        Book book = new Book("TestBook", "Spring Boot @WebMvcTest", "Description", true);

        mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void shouldReturnBook() throws Exception {
        String id = "1";
        Book book = new Book(id, "Spring Boot @WebMvcTest", "Description", true);

        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        mockMvc.perform(get("/api/books/{id}", id)).andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(book.getTitle()))
                .andExpect(jsonPath("$.author").value(book.getAuthor()))
                .andExpect(jsonPath("$.description").value(book.getDescription()))
                .andExpect(jsonPath("$.read").value(book.isRead()))
                .andDo(print());
    }

    @Test
    void shouldReturnNotFoundBook() throws Exception {
        String id = "1";

        when(bookRepository.findById(id)).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/books/{id}", id))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void shouldReturnListOfBooks() throws Exception {
        List<Book> books = new ArrayList<>(
                Arrays.asList(new Book("Testbook1", "Spring Boot @WebMvcTest 1", "Description 1", true),
                        new Book("Testbook2", "Spring Boot @WebMvcTest 2", "Description 2", true),
                        new Book("Testbook3", "Spring Boot @WebMvcTest 3", "Description 3", true)));

        when(bookRepository.findAll()).thenReturn(books);
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(books.size()))
                .andDo(print());
    }

    @Test
    void shouldUpdateBook() throws Exception {
        String id = "1";

        Book book = new Book(id, "Spring Boot @WebMvcTest", "Description", false);
        Book updatedbook = new Book(id, "Updated", "Updated", true);

        when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        when(bookRepository.save(any(Book.class))).thenReturn(updatedbook);

        mockMvc.perform(put("/api/books/{id}", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedbook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(updatedbook.getTitle()))
                .andExpect(jsonPath("$.author").value(updatedbook.getAuthor()))
                .andExpect(jsonPath("$.description").value(updatedbook.getDescription()))
                .andExpect(jsonPath("$.read").value(updatedbook.isRead()))
                .andDo(print());
    }

    @Test
    void shouldReturnNotFoundUpdateBook() throws Exception {
        String id = "1";

        Book updatedbook = new Book(id, "Updated", "Updated", true);

        when(bookRepository.findById(id)).thenReturn(Optional.empty());
        when(bookRepository.save(any(Book.class))).thenReturn(updatedbook);

        mockMvc.perform(put("/api/books/{id}", id).contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedbook)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void shouldDeleteBook() throws Exception {
        String id = "1";

        doNothing().when(bookRepository).deleteById(id);
        mockMvc.perform(delete("/api/books/{id}", id))
                .andExpect(status().isNoContent())
                .andDo(print());
    }
}
