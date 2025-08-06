package com.brainstation_23.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
//    @Column(unique = true)
    private String email;
    private String password;
    private String role; // e.g., "ADMIN" or "USER"
//    @Enumerated(EnumType.STRING)
//    private Role role = Role.USER;
//
//    public enum Role{
//        ADMIN, USER
//    }
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Borrow> borrows;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;



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
