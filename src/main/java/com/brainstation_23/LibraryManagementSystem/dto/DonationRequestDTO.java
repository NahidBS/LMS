package com.brainstation_23.LibraryManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class DonationRequestDTO {
    private Long id;
    private Long userId;
    private String bookTitle;
    private String author;
    private String description;
    private int status;
    private LocalDate requestedAt;
}
