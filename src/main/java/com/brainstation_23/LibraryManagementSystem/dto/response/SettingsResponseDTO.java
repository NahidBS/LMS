package com.brainstation_23.LibraryManagementSystem.dto.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SettingsResponseDTO {
    private Long id;
    private Integer borrowDayLimit;
    private Integer borrowExtendLimit;
    private Integer borrowBookLimit;
    private Integer bookingDaysLimit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}