package com.brainstation_23.LibraryManagementSystem.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donorName;
    private String bookTitle;
    private String author;
    private String description;
    private String message;
    private int status; // 0 = pending, 1 = accepted, -1 = rejected
//    private boolean isApproved;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private User user;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
