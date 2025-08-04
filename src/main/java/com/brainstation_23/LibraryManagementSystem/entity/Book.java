package com.brainstation_23.LibraryManagementSystem.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Book entity")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Book ID", example = "1")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    @Schema(description = "Book name", example = "Clean Code")
    private String name;

    @Schema(description = "Author name", example = "Robert C. Martin")
    private String author;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    private int totalCopies = 0;
    private int availableCopies = 0;

    @Schema(description = "Cover image path", example = "/images/clean-code.jpg")
    private String bookCover; //url or file path

    @Schema(description = "PDF file path", example = "/books/clean-code.pdf")
    private String pdfFile;

    @Schema(description = "Audio file path", example = "/audio/clean-code.mp3")
    private String audioFile;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = updatedAt = LocalDateTime.now();
    }

    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
