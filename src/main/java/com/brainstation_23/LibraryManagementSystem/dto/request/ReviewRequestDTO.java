package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long userId;
    private String content;
    private Integer rating;
}