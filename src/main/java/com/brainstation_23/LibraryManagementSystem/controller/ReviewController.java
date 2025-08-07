package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.ReviewRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.ReviewResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
@Tag(name = "Review Management", description = "Book review management APIs")
public class ReviewController {
    
    private final ReviewService reviewService;

    @PostMapping("/book/{bookId}/create")
    @Operation(summary = "Create review for a book")
    public ResponseEntity<ReviewResponseDTO> create(@PathVariable Long bookId, @RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO response = reviewService.createReview(bookId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete review")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully");
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit review")
    public ResponseEntity<ReviewResponseDTO> edit(@PathVariable Long id, @RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO response = reviewService.updateReview(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list/book/{bookId}")
    @Operation(summary = "Get all reviews for a book")
    public ResponseEntity<List<ReviewResponseDTO>> listByBook(@PathVariable Long bookId) {
        List<ReviewResponseDTO> reviews = reviewService.getReviewsByBook(bookId);
        return ResponseEntity.ok(reviews);
    }
}