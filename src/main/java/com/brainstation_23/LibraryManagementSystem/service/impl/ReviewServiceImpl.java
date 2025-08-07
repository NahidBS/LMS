package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.request.ReviewRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.ReviewResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Review;
import com.brainstation_23.LibraryManagementSystem.entity.User;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.repository.ReviewRepository;
import com.brainstation_23.LibraryManagementSystem.repository.UserRepository;
import com.brainstation_23.LibraryManagementSystem.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewResponseDTO createReview(Long bookId, ReviewRequestDTO request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Review review = Review.builder()
                .user(user)
                .book(book)
                .content(request.getContent())
                .rating(request.getRating())
                .postedAt(LocalDate.now())
                .build();

        Review saved = reviewRepository.save(review);
        return mapToResponseDTO(saved);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO request) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        
        review.setContent(request.getContent());
        review.setRating(request.getRating());
        
        Review saved = reviewRepository.save(review);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<ReviewResponseDTO> getReviewsByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private ReviewResponseDTO mapToResponseDTO(Review review) {
        ReviewResponseDTO dto = new ReviewResponseDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());
        dto.setUserName(review.getUser().getName());
        dto.setBookId(review.getBook().getId());
        dto.setBookTitle(review.getBook().getTitle());
        dto.setContent(review.getContent());
        dto.setRating(review.getRating());
        dto.setPostedAt(review.getPostedAt());
        dto.setCreatedAt(review.getCreatedAt());
        dto.setUpdatedAt(review.getUpdatedAt());
        return dto;
    }
}