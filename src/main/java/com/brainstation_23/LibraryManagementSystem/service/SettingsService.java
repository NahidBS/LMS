package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.response.SettingsResponseDTO;

public interface SettingsService {
    SettingsResponseDTO setBorrowDayLimit(Integer limit);
    SettingsResponseDTO setBorrowExtendLimit(Integer limit);
    SettingsResponseDTO setBorrowBookLimit(Integer limit);
    SettingsResponseDTO setBookingDaysLimit(Integer limit);
    SettingsResponseDTO getCurrentSettings();
}