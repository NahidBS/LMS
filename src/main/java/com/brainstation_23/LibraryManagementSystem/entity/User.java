package com.brainstation_23.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public enum Role{
        ADMIN, USER
    }

    private String dateOfBirth;
    private String address;
    private String profilePicture;

    private LocalDateTime emailVerifiedAt;

    private String rememberToken;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
