package com.brainstation_23.LibraryManagementSystem.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DonationRequestResponseDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String bookTitle;
    private String author;
    private String description;
    private String message;
    private int status; // 0 = pending, 1 = accepted, -1 = rejected
    private String statusText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}