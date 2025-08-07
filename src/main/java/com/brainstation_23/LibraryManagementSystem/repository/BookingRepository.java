package com.brainstation_23.LibraryManagementSystem.repository;

import com.brainstation_23.LibraryManagementSystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByBookId(Long bookId);
}