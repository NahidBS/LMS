package com.brainstation_23.LibraryManagementSystem.dto.response;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String shortDescription;
    private boolean isAvailable;
    private int totalCopies;
    private int availableCopies;
    private String bookCover;
    private String pdfFile;
    private String audioFile;
    private LocalDate publishedDate;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}