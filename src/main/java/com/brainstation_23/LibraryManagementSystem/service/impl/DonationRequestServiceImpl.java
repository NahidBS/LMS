package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.request.DonationRequestCreateDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.DonationRequestResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.DonationRequest;
import com.brainstation_23.LibraryManagementSystem.entity.User;
import com.brainstation_23.LibraryManagementSystem.repository.DonationRequestRepository;
import com.brainstation_23.LibraryManagementSystem.repository.UserRepository;
import com.brainstation_23.LibraryManagementSystem.service.DonationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationRequestServiceImpl implements DonationRequestService {
    
    private final DonationRequestRepository donationRequestRepository;
    private final UserRepository userRepository;

    @Override
    public DonationRequestResponseDTO createDonationRequest(DonationRequestCreateDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        DonationRequest donationRequest = DonationRequest.builder()
                .user(user)
                .bookTitle(request.getBookTitle())
                .author(request.getAuthor())
                .description(request.getDescription())
                .message(request.getMessage())
                .status(0) // Pending
                .build();

        DonationRequest saved = donationRequestRepository.save(donationRequest);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<DonationRequestResponseDTO> getAllDonationRequests() {
        return donationRequestRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonationRequestResponseDTO getDonationRequestById(Long id) {
        DonationRequest donationRequest = donationRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation request not found"));
        return mapToResponseDTO(donationRequest);
    }

    @Override
    public DonationRequestResponseDTO updateDonationRequest(Long id, DonationRequestCreateDTO request) {
        DonationRequest donationRequest = donationRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation request not found"));
        
        donationRequest.setBookTitle(request.getBookTitle());
        donationRequest.setAuthor(request.getAuthor());
        donationRequest.setDescription(request.getDescription());
        donationRequest.setMessage(request.getMessage());
        
        DonationRequest saved = donationRequestRepository.save(donationRequest);
        return mapToResponseDTO(saved);
    }

    @Override
    public void deleteDonationRequest(Long id) {
        donationRequestRepository.deleteById(id);
    }

    @Override
    public DonationRequestResponseDTO updateStatus(Long id, int status) {
        DonationRequest donationRequest = donationRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation request not found"));
        
        donationRequest.setStatus(status);
        DonationRequest saved = donationRequestRepository.save(donationRequest);
        return mapToResponseDTO(saved);
    }

    private DonationRequestResponseDTO mapToResponseDTO(DonationRequest donationRequest) {
        DonationRequestResponseDTO dto = new DonationRequestResponseDTO();
        dto.setId(donationRequest.getId());
        dto.setUserId(donationRequest.getUser().getId());
        dto.setUserName(donationRequest.getUser().getName());
        dto.setBookTitle(donationRequest.getBookTitle());
        dto.setAuthor(donationRequest.getAuthor());
        dto.setDescription(donationRequest.getDescription());
        dto.setMessage(donationRequest.getMessage());
        dto.setStatus(donationRequest.getStatus());
        dto.setStatusText(getStatusText(donationRequest.getStatus()));
        dto.setCreatedAt(donationRequest.getCreatedAt());
        dto.setUpdatedAt(donationRequest.getUpdatedAt());
        return dto;
    }

    private String getStatusText(int status) {
        switch (status) {
            case 0: return "Pending";
            case 1: return "Accepted";
            case -1: return "Rejected";
            default: return "Unknown";
        }
    }
}