package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.response.SettingsResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Settings;
import com.brainstation_23.LibraryManagementSystem.repository.SettingsRepository;
import com.brainstation_23.LibraryManagementSystem.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingsServiceImpl implements SettingsService {
    
    private final SettingsRepository settingsRepository;

    @Override
    public SettingsResponseDTO setBorrowDayLimit(Integer limit) {
        Settings settings = getOrCreateSettings();
        settings.setBorrowDayLimit(limit);
        Settings saved = settingsRepository.save(settings);
        return mapToResponseDTO(saved);
    }

    @Override
    public SettingsResponseDTO setBorrowExtendLimit(Integer limit) {
        Settings settings = getOrCreateSettings();
        settings.setBorrowExtendLimit(limit);
        Settings saved = settingsRepository.save(settings);
        return mapToResponseDTO(saved);
    }

    @Override
    public SettingsResponseDTO setBorrowBookLimit(Integer limit) {
        Settings settings = getOrCreateSettings();
        settings.setBorrowBookLimit(limit);
        Settings saved = settingsRepository.save(settings);
        return mapToResponseDTO(saved);
    }

    @Override
    public SettingsResponseDTO setBookingDaysLimit(Integer limit) {
        Settings settings = getOrCreateSettings();
        settings.setBorrowDaysLimit(limit);
        Settings saved = settingsRepository.save(settings);
        return mapToResponseDTO(saved);
    }

    @Override
    public SettingsResponseDTO getCurrentSettings() {
        Settings settings = getOrCreateSettings();
        return mapToResponseDTO(settings);
    }

    private Settings getOrCreateSettings() {
        return settingsRepository.findAll().stream()
                .findFirst()
                .orElseGet(() -> {
                    Settings newSettings = Settings.builder()
                            .borrowDayLimit(14)
                            .borrowExtendLimit(7)
                            .borrowBookLimit(3)
                            .borrowDaysLimit(3)
                            .build();
                    return settingsRepository.save(newSettings);
                });
    }

    private SettingsResponseDTO mapToResponseDTO(Settings settings) {
        SettingsResponseDTO dto = new SettingsResponseDTO();
        dto.setId(settings.getId());
        dto.setBorrowDayLimit(settings.getBorrowDayLimit());
        dto.setBorrowExtendLimit(settings.getBorrowExtendLimit());
        dto.setBorrowBookLimit(settings.getBorrowBookLimit());
        dto.setBookingDaysLimit(settings.getBorrowDaysLimit());
        dto.setCreatedAt(settings.getCreatedAt());
        dto.setUpdatedAt(settings.getUpdatedAt());
        return dto;
    }
}