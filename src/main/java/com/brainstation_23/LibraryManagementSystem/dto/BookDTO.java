package com.brainstation_23.LibraryManagementSystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDTO {

    @Schema(description = "Unique identifier of the book", example = "1")
    private Long id;

    @Schema(description = "ID of the book's category", example = "2")
    private Long categoryId;

    @Schema(description = "Title of the book", example = "Clean Code")
    private String name;

    @Schema(description = "Author name", example = "Robert C. Martin")
    private String author;

    @Schema(description = "Short description of the book", example = "A handbook of agile software craftsmanship")
    private String shortDescription;

    @Schema(description = "Total copies of the book", example = "10")
    private int totalCopies = 0;

    @Schema(description = "Currently available copies", example = "7")
    private int availableCopies = 0;

    @Schema(description = "URL or path to the book cover image", example = "/images/clean_code.jpg")
    private String bookCover; //url or file path

    @Schema(description = "URL or path to the PDF version", example = "/pdfs/clean_code.pdf")
    private String pdfFile;

    @Schema(description = "URL or path to the audio file", example = "/audio/clean_code.mp3")
    private String audioFile;

    @Schema(description = "Created timestamp", example = "2025-08-04T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Last updated timestamp", example = "2025-08-04T13:00:00")
    private LocalDateTime updatedAt;
}
