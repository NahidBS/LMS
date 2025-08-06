package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.AuthResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    AuthResponseDTO toDTO(String token);
}
