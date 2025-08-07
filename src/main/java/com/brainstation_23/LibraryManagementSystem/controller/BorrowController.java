package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.BorrowRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BorrowResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.BorrowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
@Tag(name = "Borrow Management", description = "Book borrowing management APIs")
public class BorrowController {
    
    private final BorrowService borrowService;

    @PostMapping("/create")
    @Operation(summary = "Create new borrow record")
    public ResponseEntity<BorrowResponseDTO> create(@RequestBody BorrowRequestDTO request) {
        BorrowResponseDTO response = borrowService.createBorrow(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @Operation(summary = "Get all borrow records")
    public ResponseEntity<List<BorrowResponseDTO>> list() {
        List<BorrowResponseDTO> borrows = borrowService.getAllBorrows();
        return ResponseEntity.ok(borrows);
    }

    @PutMapping("/date_extend/{id}")
    @Operation(summary = "Extend borrow due date")
    public ResponseEntity<BorrowResponseDTO> extendDate(@PathVariable Long id) {
        BorrowResponseDTO response = borrowService.extendBorrowDate(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/return/{id}")
    @Operation(summary = "Return borrowed book")
    public ResponseEntity<String> returnBook(@PathVariable Long id) {
        borrowService.returnBook(id);
        return ResponseEntity.ok("Book returned successfully");
    }

    @GetMapping("/retrieve/{id}")
    @Operation(summary = "Get borrow record by ID")
    public ResponseEntity<BorrowResponseDTO> retrieve(@PathVariable Long id) {
        BorrowResponseDTO response = borrowService.getBorrowById(id);
        return ResponseEntity.ok(response);
    }
}