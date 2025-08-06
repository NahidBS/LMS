package com.brainstation_23.LibraryManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class BorrowDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean isReturned;
}
