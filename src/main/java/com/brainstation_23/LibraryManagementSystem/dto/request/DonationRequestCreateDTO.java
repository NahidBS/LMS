package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;

@Data
public class DonationRequestCreateDTO {
    private Long userId;
    private String bookTitle;
    private String author;
    private String description;
    private String message;
}