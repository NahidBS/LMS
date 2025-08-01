package com.brainstation_23.LibraryManagementSystem.entity;

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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
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
