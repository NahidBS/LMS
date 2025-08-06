package com.brainstation_23.LibraryManagementSystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
//    @Schema(description = "Unique identifier of the category", example = "1")
//    private Long id;
//
//    @Schema(description = "Name of the category", example = "Computer Science")
//    private String categoryName;
//
//    @Schema(description = "Created timestamp", example = "2025-08-04T12:00:00")
//    private LocalDateTime createdAt;
//
//    @Schema(description = "Last updated timestamp", example = "2025-08-04T13:00:00")
//    private LocalDateTime updatedAt;

}
