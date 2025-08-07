package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookingRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookingResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Booking;
import com.brainstation_23.LibraryManagementSystem.entity.User;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.repository.BookingRepository;
import com.brainstation_23.LibraryManagementSystem.repository.UserRepository;
import com.brainstation_23.LibraryManagementSystem.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    
    private final BookingRepository bookingRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Booking booking = Booking.builder()
                .user(user)
                .book(book)
                .bookingDate(LocalDateTime.now())
                .expirationDateDate(LocalDateTime.now().plusDays(3)) // Default 3 days
                .build();

        Booking saved = bookingRepository.save(booking);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return mapToResponseDTO(booking);
    }

    private BookingResponseDTO mapToResponseDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUser().getId());
        dto.setUserName(booking.getUser().getName());
        dto.setBookId(booking.getBook().getId());
        dto.setBookTitle(booking.getBook().getTitle());
        dto.setBookingDate(booking.getBookingDate().toLocalDate());
        dto.setExpirationDate(booking.getExpirationDateDate().toLocalDate());
        dto.setCreatedAt(booking.getCreatedAt());
        dto.setUpdatedAt(booking.getUpdatedAt());
        return dto;
    }
}