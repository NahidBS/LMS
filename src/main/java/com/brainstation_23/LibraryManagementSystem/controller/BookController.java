package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.BookDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO){
        BookDTO created = bookService.createBook(bookDTO);
        return ResponseEntity.ok(created);
    }

    @GetMapping("List")
    public ResponseEntity<List<BookDTO>> listBooks(){
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}/is_available")
    public ResponseEntity<Boolean> isBookAvailable(@PathVariable Long id){
        BookDTO book = bookService.getBookById(id);
        boolean isAvailable = book.getAvailableCopies() > 0;
        return ResponseEntity.ok(isAvailable);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
//        return  ResponseEntity.noContent().build();
        return  ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/retrieve/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id){
        BookDTO book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }





//    public BookController(BookService bookService){
//        this.bookService = bookService;
//    }
//    @PostMapping
//    public ResponseEntity<Book> create(@RequestBody Book book){
//        return ResponseEntity.ok(bookService.createBook(book));
//    }
//    @GetMapping
//    public ResponseEntity<List<Book>> getAll(){
//        return ResponseEntity.ok(bookService.getAllBooks());
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Book> getById(@PathVariable Long id){
//        return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
//        return  ResponseEntity.ok(bookService.updateBook(id, book));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        bookService.deleteBook(id);
//        return ResponseEntity.noContent().build();
//    }

}
