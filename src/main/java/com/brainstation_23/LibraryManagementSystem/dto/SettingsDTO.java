package com.brainstation_23.LibraryManagementSystem.dto;

import lombok.*;

@Data
public class SettingsDTO {
    private int borrowDayLimit;
    private int borrowExtendLimit;
    private int borrowBookLimit;
    private int bookingDaysLimit;
}
