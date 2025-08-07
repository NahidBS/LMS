package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.BorrowRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BorrowResponseDTO;

import java.util.List;

public interface BorrowService {
    BorrowResponseDTO createBorrow(BorrowRequestDTO request);
    List<BorrowResponseDTO> getAllBorrows();
    BorrowResponseDTO extendBorrowDate(Long id);
    void returnBook(Long id);
    BorrowResponseDTO getBorrowById(Long id);
}