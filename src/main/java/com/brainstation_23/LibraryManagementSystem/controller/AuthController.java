package com.brainstation_23.LibraryManagementSystem.controller;

import com.brainstation_23.LibraryManagementSystem.dto.request.AuthRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.AuthResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@Tag(name = "Authentication", description = "Authentication management APIs")
public class AuthController {

    @PostMapping
    @Operation(summary = "Authenticate user", description = "Login with email and password")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthRequestDTO request) {
        // TODO: Implement authentication logic
        AuthResponseDTO response = new AuthResponseDTO("dummy-jwt-token", "Authentication successful");
        return ResponseEntity.ok(response);
    }
}