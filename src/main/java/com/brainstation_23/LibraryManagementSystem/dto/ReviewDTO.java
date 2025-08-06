package com.brainstation_23.LibraryManagementSystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReviewDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private String content;
    private int rating;
    private LocalDate postedAt;
}