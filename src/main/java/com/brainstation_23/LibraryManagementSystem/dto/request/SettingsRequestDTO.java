package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;

@Data
public class SettingsRequestDTO {
    private Integer borrowDayLimit;
    private Integer borrowExtendLimit;
    private Integer borrowBookLimit;
    private Integer bookingDaysLimit;
}