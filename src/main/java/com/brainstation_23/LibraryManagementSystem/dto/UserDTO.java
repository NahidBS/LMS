package com.brainstation_23.LibraryManagementSystem.dto;

import lombok.*;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private Boolean isActive;
}