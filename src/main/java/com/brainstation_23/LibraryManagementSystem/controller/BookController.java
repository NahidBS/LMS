package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Tag(name = "Book Management", description = "Book management APIs")
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    @Operation(summary = "Create new book")
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO request){
        BookResponseDTO created = bookService.createBook(request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/list")
    @Operation(summary = "Get all books")
    public ResponseEntity<List<BookResponseDTO>> listBooks(){
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}/is_available")
    @Operation(summary = "Check if book is available")
    public ResponseEntity<Boolean> isBookAvailable(@PathVariable Long id){
        BookResponseDTO book = bookService.getBookById(id);
        boolean isAvailable = book.getAvailableCopies() > 0;
        return ResponseEntity.ok(isAvailable);
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Update book")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO request){
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete book")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return  ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/retrieve/{id}")
    @Operation(summary = "Get book by ID")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable Long id){
        BookResponseDTO book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

}
