package com.brainstation_23.LibraryManagementSystem.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private Long id;
    @Column(nullable = false)
    private String title;
    private String author;
    private String isbn;
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    private boolean isAvailable = true;
    private int totalCopies = 0;
    private int availableCopies = 0;
    private String bookCover; //url or file path
    private String pdfFile;
    private String audioFile;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = true)
//    private Category category;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
