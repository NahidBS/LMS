package com.brainstation_23.LibraryManagementSystem.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer borrowDayLimit;
    private Integer borrowExtendLimit;
    private Integer borrowBookLimit;
    private Integer borrowDaysLimit;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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
