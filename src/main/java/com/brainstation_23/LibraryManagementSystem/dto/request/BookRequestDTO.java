package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookRequestDTO {
    private String title;
    private String author;
    private String isbn;
    private String shortDescription;
    private int totalCopies;
    private int availableCopies;
    private String bookCover;
    private String pdfFile;
    private String audioFile;
    private Long categoryId;
    private LocalDate publishedDate;
}