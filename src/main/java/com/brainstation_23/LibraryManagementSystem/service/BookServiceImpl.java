package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.BookRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.BookResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepo;
    private final CategoryRepository categoryRepo;

    @Override
    public BookResponseDTO createBook(BookRequestDTO request){
        Book book = mapToEntity(request);

        if (request.getCategoryId() == null) {
            Category defaultCategory = categoryRepo.findByName("Uncategorized")
                    .orElseGet(() -> {
                        Category newCat = new Category();
                        newCat.setName("Uncategorized");
                        return categoryRepo.save(newCat);
                    });
            book.setCategory(defaultCategory);
        } else {
            Category category = categoryRepo.findById(request.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id " + request.getCategoryId()));
            book.setCategory(category);
        }

        Book saved = bookRepo.save(book);// Save entity to the database
        return mapToResponseDTO(saved);  // Convert saved entity back to DTO to return
    }
    
    @Override
    public List<BookResponseDTO> getAllBooks(){
        //Get all book entities from database
        List<Book> books = bookRepo.findAll();
        // Convert each Book entity to BookDTO and collect into a list
        List<BookResponseDTO> bookDTOlist = books.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
        return bookDTOlist;
    }
    
    public BookResponseDTO updateBook(Long id, BookRequestDTO request){
        Book existing = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Book updated = mapToEntity(request);
        updated.setId(existing.getId());

        if (request.getCategoryId() == null) {
            throw new RuntimeException("Category ID must be provided");
        }
        Category category = categoryRepo.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + request.getCategoryId()));

        updated.setCategory(category);

        Book saved = bookRepo.save(updated);
        return mapToResponseDTO(saved);
    }

    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }
    
    public BookResponseDTO getBookById(Long id){
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book Not found"));
        return mapToResponseDTO(book);
    }
    
    private Book mapToEntity(BookRequestDTO request) {
        return Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .shortDescription(request.getShortDescription())
                .totalCopies(request.getTotalCopies())
                .availableCopies(request.getAvailableCopies())
                .bookCover(request.getBookCover())
                .pdfFile(request.getPdfFile())
                .audioFile(request.getAudioFile())
                .isAvailable(request.getAvailableCopies() > 0)
                .build();
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
