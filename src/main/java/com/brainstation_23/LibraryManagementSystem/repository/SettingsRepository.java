package com.brainstation_23.LibraryManagementSystem.repository;

import com.brainstation_23.LibraryManagementSystem.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<Settings, Long> {
}