package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long userId;
    private Long bookId;
    private LocalDate bookingDate;
    private LocalDate expirationDate;
}