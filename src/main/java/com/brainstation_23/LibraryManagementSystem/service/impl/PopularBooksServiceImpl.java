package com.brainstation_23.LibraryManagementSystem.service.impl;

import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.service.PopularBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PopularBooksServiceImpl implements PopularBooksService {
    
    private final BookRepository bookRepository;

    @Override
    public List<BookResponseDTO> getPopularBooks() {
        // For now, return books with highest total copies (most popular)
        List<Book> books = bookRepository.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "totalCopies"))
        ).getContent();
        
        return books.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponseDTO> getRecommendedBooks() {
        // For now, return books with available copies
        List<Book> books = bookRepository.findAll().stream()
                .filter(book -> book.getAvailableCopies() > 0)
                .limit(10)
                .collect(Collectors.toList());
        
        return books.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponseDTO> getNewCollection() {
        // Return recently added books
        List<Book> books = bookRepository.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createdAt"))
        ).getContent();
        
        return books.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private BookResponseDTO mapToResponseDTO(Book book) {
        BookResponseDTO dto = new BookResponseDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setShortDescription(book.getShortDescription());
        dto.setAvailable(book.isAvailable());
        dto.setTotalCopies(book.getTotalCopies());
        dto.setAvailableCopies(book.getAvailableCopies());
        dto.setBookCover(book.getBookCover());
        dto.setPdfFile(book.getPdfFile());
        dto.setAudioFile(book.getAudioFile());
        if (book.getCategory() != null) {
            dto.setCategoryId(book.getCategory().getId());
            dto.setCategoryName(book.getCategory().getName());
        }
        dto.setCreatedAt(book.getCreatedAt());
        dto.setUpdatedAt(book.getUpdatedAt());
        return dto;
    }
}