package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookingRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookingResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
@Tag(name = "Booking Management", description = "Book booking management APIs")
public class BookingController {
    
    private final BookingService bookingService;

    @PostMapping("/create")
    @Operation(summary = "Create new booking")
    public ResponseEntity<BookingResponseDTO> create(@RequestBody BookingRequestDTO request) {
        BookingResponseDTO response = bookingService.createBooking(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @Operation(summary = "Get all bookings")
    public ResponseEntity<List<BookingResponseDTO>> list() {
        List<BookingResponseDTO> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Cancel booking")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking cancelled successfully");
    }

    @GetMapping("/retrieve/{id}")
    @Operation(summary = "Get booking by ID")
    public ResponseEntity<BookingResponseDTO> retrieve(@PathVariable Long id) {
        BookingResponseDTO response = bookingService.getBookingById(id);
        return ResponseEntity.ok(response);
    }
}