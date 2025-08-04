package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.BookDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDTO createBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    BookDTO getBookById(Long id);





//   Service without DTO
//    Book createBook(Book book);
//    List<Book> getAllBooks();
//    Optional<Book> getBookById(Long id);
//    Book updateBook(Long id, Book book);
//    void deleteBook(Long id);

}
