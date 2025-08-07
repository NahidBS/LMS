package com.brainstation_23.LibraryManagementSystem.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReviewResponseDTO {
    private Long id;
    private Long userId;
    private String userName;
    private Long bookId;
    private String bookTitle;
    private String content;
    private Integer rating;
    private LocalDate postedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}