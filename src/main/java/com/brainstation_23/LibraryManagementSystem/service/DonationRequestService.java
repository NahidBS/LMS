package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.DonationRequestCreateDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.DonationRequestResponseDTO;

import java.util.List;

public interface DonationRequestService {
    DonationRequestResponseDTO createDonationRequest(DonationRequestCreateDTO request);
    List<DonationRequestResponseDTO> getAllDonationRequests();
    DonationRequestResponseDTO getDonationRequestById(Long id);
    DonationRequestResponseDTO updateDonationRequest(Long id, DonationRequestCreateDTO request);
    void deleteDonationRequest(Long id);
    DonationRequestResponseDTO updateStatus(Long id, int status);
}