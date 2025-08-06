package com.brainstation_23.LibraryManagementSystem.dto;

import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.User;
import io.swagger.v3.oas.annotations.media.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate bookingDate;
    private LocalDate expirationDate;
//    @Schema(description = "Unique identifier of the booking", example = "1")
//    private Long id;
//
//    @Schema(description = "ID of the user who booked", example = "5")
//    private Long userId;
//
//    @Schema(description = "ID of the booked book", example = "3")
//    private Long bookId;
//
//    @Schema(description = "Booking creation timestamp", example = "2025-08-04T14:00:00")
//    private LocalDateTime bookingDate;
//
//    @Schema(description = "Expiration date of the booking", example = "2025-08-10T14:00:00")
//    private LocalDateTime expiryDate;
//
//    @Schema(description = "Created timestamp", example = "2025-08-04T12:00:00")
//    private LocalDateTime createdAt;
//
//    @Schema(description = "Last updated timestamp", example = "2025-08-04T13:00:00")
//    private LocalDateTime updatedAt;

}
