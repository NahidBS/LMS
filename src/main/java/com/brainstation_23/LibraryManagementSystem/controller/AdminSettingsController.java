package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.SettingsRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.SettingsResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.SettingsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Admin Settings", description = "Library settings management APIs")
public class AdminSettingsController {
    
    private final SettingsService settingsService;

    @PostMapping("/borrow-day-limit")
    @Operation(summary = "Set borrow day limit")
    public ResponseEntity<SettingsResponseDTO> setBorrowDayLimit(@RequestParam Integer limit) {
        SettingsResponseDTO response = settingsService.setBorrowDayLimit(limit);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/borrow-extend-limit")
    @Operation(summary = "Set borrow extend limit")
    public ResponseEntity<SettingsResponseDTO> setBorrowExtendLimit(@RequestParam Integer limit) {
        SettingsResponseDTO response = settingsService.setBorrowExtendLimit(limit);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/borrow-book-limit")
    @Operation(summary = "Set borrow book limit")
    public ResponseEntity<SettingsResponseDTO> setBorrowBookLimit(@RequestParam Integer limit) {
        SettingsResponseDTO response = settingsService.setBorrowBookLimit(limit);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/booking-days-limit")
    @Operation(summary = "Set booking days limit")
    public ResponseEntity<SettingsResponseDTO> setBookingDaysLimit(@RequestParam Integer limit) {
        SettingsResponseDTO response = settingsService.setBookingDaysLimit(limit);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/settings")
    @Operation(summary = "Get current settings")
    public ResponseEntity<SettingsResponseDTO> getSettings() {
        SettingsResponseDTO response = settingsService.getCurrentSettings();
        return ResponseEntity.ok(response);
    }
}