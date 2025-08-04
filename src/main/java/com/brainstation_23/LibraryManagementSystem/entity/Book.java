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
    @Schema(description = "Book ID", example = "0")
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    private String name;
    private String author;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    private int totalCopies = 0;
    private int availableCopies = 0;

    private String bookCover; //url or file path
    private String pdfFile;
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
