package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.SettingsDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Settings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingsMapper {
    SettingsDTO toDTO(Settings settings);
    Settings toEntity(SettingsDTO dto);
}
