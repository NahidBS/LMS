package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.DonationRequestCreateDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.DonationRequestResponseDTO;
import com.brainstation_23.LibraryManagementSystem.service.DonationRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donation-req")
@RequiredArgsConstructor
@Tag(name = "Donation Request", description = "Book donation request management APIs")
public class DonationRequestController {
    
    private final DonationRequestService donationRequestService;

    @PostMapping("/create")
    @Operation(summary = "Create donation request")
    public ResponseEntity<DonationRequestResponseDTO> create(@RequestBody DonationRequestCreateDTO request) {
        DonationRequestResponseDTO response = donationRequestService.createDonationRequest(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    @Operation(summary = "Get all donation requests")
    public ResponseEntity<List<DonationRequestResponseDTO>> list() {
        List<DonationRequestResponseDTO> requests = donationRequestService.getAllDonationRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/retrieve/{id}")
    @Operation(summary = "Get donation request by ID")
    public ResponseEntity<DonationRequestResponseDTO> retrieve(@PathVariable Long id) {
        DonationRequestResponseDTO response = donationRequestService.getDonationRequestById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit donation request")
    public ResponseEntity<DonationRequestResponseDTO> edit(@PathVariable Long id, @RequestBody DonationRequestCreateDTO request) {
        DonationRequestResponseDTO response = donationRequestService.updateDonationRequest(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete donation request")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        donationRequestService.deleteDonationRequest(id);
        return ResponseEntity.ok("Donation request deleted successfully");
    }

    @PostMapping("/status/{id}")
    @Operation(summary = "Update donation request status")
    public ResponseEntity<DonationRequestResponseDTO> updateStatus(@PathVariable Long id, @RequestParam int status) {
        DonationRequestResponseDTO response = donationRequestService.updateStatus(id, status);
        return ResponseEntity.ok(response);
    }
}