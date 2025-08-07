package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.request.BorrowRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BorrowResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Borrow;
import com.brainstation_23.LibraryManagementSystem.entity.User;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.repository.BorrowRepository;
import com.brainstation_23.LibraryManagementSystem.repository.UserRepository;
import com.brainstation_23.LibraryManagementSystem.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public BorrowResponseDTO createBorrow(BorrowRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        Borrow borrow = Borrow.builder()
                .user(user)
                .book(book)
                .borrowDate(LocalDateTime.now())
                .dueDate(LocalDateTime.now().plusDays(14)) // Default 14 days
                .isReturned(false)
                .build();

        // Decrease available copies
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        Borrow saved = borrowRepository.save(borrow);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<BorrowResponseDTO> getAllBorrows() {
        return borrowRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowResponseDTO extendBorrowDate(Long id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        
        borrow.setDueDate(borrow.getDueDate().plusDays(7)); // Extend by 7 days
        Borrow saved = borrowRepository.save(borrow);
        return mapToResponseDTO(saved);
    }

    @Override
    public void returnBook(Long id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        
        borrow.setReturnDate(LocalDateTime.now());
        borrow.setReturned(true);
        
        // Increase available copies
        Book book = borrow.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        
        borrowRepository.save(borrow);
    }

    @Override
    public BorrowResponseDTO getBorrowById(Long id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
        return mapToResponseDTO(borrow);
    }

    private BorrowResponseDTO mapToResponseDTO(Borrow borrow) {
        BorrowResponseDTO dto = new BorrowResponseDTO();
        dto.setId(borrow.getId());
        dto.setUserId(borrow.getUser().getId());
        dto.setUserName(borrow.getUser().getName());
        dto.setBookId(borrow.getBook().getId());
        dto.setBookTitle(borrow.getBook().getTitle());
        dto.setBorrowDate(borrow.getBorrowDate().toLocalDate());
        dto.setDueDate(borrow.getDueDate().toLocalDate());
        if (borrow.getReturnDate() != null) {
            dto.setReturnDate(borrow.getReturnDate().toLocalDate());
        }
        dto.setReturned(borrow.isReturned());
        dto.setCreatedAt(borrow.getCreatedAt());
        dto.setUpdatedAt(borrow.getUpdatedAt());
        return dto;
    }
}