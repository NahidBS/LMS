package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookResponseDTO createBook(BookRequestDTO request);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO updateBook(Long id, BookRequestDTO request);
    void deleteBook(Long id);
    BookResponseDTO getBookById(Long id);
}
