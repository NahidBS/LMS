package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.DonationRequestDTO;
import com.brainstation_23.LibraryManagementSystem.entity.DonationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DonationRequestMapper {
    @Mapping(source = "user.id", target = "userId")
    DonationRequestDTO toDTO(DonationRequest donationRequest);

    @Mapping(source = "userId", target = "user.id")
    DonationRequest toEntity(DonationRequestDTO dto);
}
