package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookingRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookingResponseDTO;

import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);
    List<BookingResponseDTO> getAllBookings();
    void cancelBooking(Long id);
    BookingResponseDTO getBookingById(Long id);
}