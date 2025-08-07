package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.ReviewRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {
    ReviewResponseDTO createReview(Long bookId, ReviewRequestDTO request);
    void deleteReview(Long id);
    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO request);
    List<ReviewResponseDTO> getReviewsByBook(Long bookId);
}