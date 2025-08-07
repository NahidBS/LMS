package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.PopularBooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
@Tag(name = "Popular Books", description = "Popular and recommended books APIs")
public class PopularBooksController {
    
    private final PopularBooksService popularBooksService;

    @GetMapping("/popular-books")
    @Operation(summary = "Get popular books")
    public ResponseEntity<List<BookResponseDTO>> getPopularBooks() {
        List<BookResponseDTO> books = popularBooksService.getPopularBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/recommended-books")
    @Operation(summary = "Get recommended books")
    public ResponseEntity<List<BookResponseDTO>> getRecommendedBooks() {
        List<BookResponseDTO> books = popularBooksService.getRecommendedBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/new-collection")
    @Operation(summary = "Get new collection books")
    public ResponseEntity<List<BookResponseDTO>> getNewCollection() {
        List<BookResponseDTO> books = popularBooksService.getNewCollection();
        return ResponseEntity.ok(books);
    }
}