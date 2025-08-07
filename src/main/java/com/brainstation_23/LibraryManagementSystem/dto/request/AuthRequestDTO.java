package com.brainstation_23.LibraryManagementSystem.dto.request;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}