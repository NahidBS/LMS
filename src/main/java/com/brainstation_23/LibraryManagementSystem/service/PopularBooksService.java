package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;

import java.util.List;

public interface PopularBooksService {
    List<BookResponseDTO> getPopularBooks();
    List<BookResponseDTO> getRecommendedBooks();
    List<BookResponseDTO> getNewCollection();
}