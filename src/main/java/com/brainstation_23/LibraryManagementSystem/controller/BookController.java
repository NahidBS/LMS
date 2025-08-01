package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @Operation(
            summary = "Create a new book",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Book object that needs to be created",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Book.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Book created successfully",
                            content = @Content(schema = @Schema(implementation = Book.class))
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @Operation(
            summary = "Get all books",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of books",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Book.class, type = "array")))
            }
    )
    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Operation(
            summary = "Get a book by its ID",
            description = "Provide a book ID to look up specific book details",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Book found",
                            content = @Content(schema = @Schema(implementation = Book.class))),
                    @ApiResponse(responseCode = "404", description = "Book not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        return bookService.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Update a book by its ID",
            requestBody = @RequestBody(
                    description = "Updated book object",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Book.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Book updated successfully",
                            content = @Content(schema = @Schema(implementation = Book.class))),
                    @ApiResponse(responseCode = "404", description = "Book not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        return  ResponseEntity.ok(bookService.updateBook(id, book));
    }


    @Operation(
            summary = "Delete a book by its ID",
            responses = {
        @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Book not found")
    }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
