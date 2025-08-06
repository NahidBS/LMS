package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.BookDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.mapper.BookMapper;
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
    private final BookMapper bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDTO){
        Book book = bookMapper.toEntity(bookDTO);// Convert DTO to Entity

        if (book.getCategory() == null || book.getCategory().getId() == null) {
            Category defaultCategory = categoryRepo.findByCategoryName("Uncategorized")
                    .orElseGet(() -> {
                        Category newCat = new Category();
                        newCat.setCategoryName("Uncategorized");
                        return categoryRepo.save(newCat);
                    });
            book.setCategory(defaultCategory);
        } else {
            Long categoryId = book.getCategory().getId();
            Category category = categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
            book.setCategory(category);
        }


//        Category category = categoryRepo.findById(book.getCategory().getId())
//                .orElseThrow(() -> new RuntimeException("Category not found with id " + book.getCategory().getId()));
//
//        book.setCategory(category);

        Book saved = bookRepo.save(book);// Save entity to the database
        return bookMapper.toDTO(saved);  // Convert saved entity back to DTO to return
    }
    @Override
    public List<BookDTO> getAllBooks(){
        //Get all book entities from database
        List<Book> books = bookRepo.findAll();
        // Convert each Book entity to BookDTO and collect into a list
        List<BookDTO> bookDTOlist = books.stream().map(bookMapper::toDTO).collect(Collectors.toList());
        return bookDTOlist;
    }
    public BookDTO updateBook(Long id, BookDTO bookDTO){
        Book existing = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        Book updated = bookMapper.toEntity(bookDTO);
        updated.setId(existing.getId());

        if (updated.getCategory() == null || updated.getCategory().getId() == null) {
            throw new RuntimeException("Category ID must be provided");
        }
        Category category = categoryRepo.findById(updated.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + updated.getCategory().getId()));

        updated.setCategory(category);

//        Book updated = bookMapper.toEntity(bookDTO);
//        updated.setId(book.getId()); // Keep the same ID
        Book saved = bookRepo.save(updated);
        return bookMapper.toDTO(saved);
    }

    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }
    public BookDTO getBookById(Long id){
        Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book Not found"));
        return bookMapper.toDTO(book);
    }
}



//@Service
//public class BookServiceImpl implements BookService {
//
//    private final BookRepository bookRepo;
//    private final CategoryRepository categoryRepo;
//
//
//    public BookServiceImpl(BookRepository bookRepo, CategoryRepository categoryRepo){
//        this.bookRepo = bookRepo;
//        this.categoryRepo = categoryRepo;
//    }
//
//
//    //
//    @Override
//    public Book createBook(Book book){
////        if (book.getCategory() == null || book.getCategory().getId() == null) {
////            // Fallback to default category
////            Category defaultCategory = categoryRepo.findByName("Uncategorized");
////            if (defaultCategory == null) {
////                throw new RuntimeException("Default category 'Uncategorized' not found.");
////            }
////            book.setCategory(defaultCategory);
////        } else {
////            Long categoryId = book.getCategory().getId();
////            Category category = categoryRepo.findById(categoryId)
////                    .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
////            book.setCategory(category);
////        }
////        return  bookRepo.save(book);
//        if (book.getCategory() == null) {
//            Category defaultCategory = categoryRepo.findByCategoryName("Uncategorized")
//                    .orElseGet(() -> {
//                        Category newCategory = new Category();
//                        newCategory.setCategoryName("Uncategorized");
//                        return categoryRepo.save(newCategory);
//                    });
//            book.setCategory(defaultCategory);
//        } else {
//            Long categoryId = book.getCategory().getId();
//            Category category = categoryRepo.findById(categoryId)
//                    .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
//            book.setCategory(category);
//        }
//        return bookRepo.save(book);
//    }
//
//    @Override
//    public List<Book> getAllBooks(){
//        return bookRepo.findAll();
//    }
//
//    @Override
//    public Optional<Book> getBookById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Book updateBook(Long id, Book updatedBook) {
//        Book book = bookRepo.findById(id).orElseThrow();
//        book.setName(updatedBook.getName());
//        book.setAuthor(updatedBook.getAuthor());
//        book.setShortDescription(updatedBook.getShortDescription());
//        book.setAvailableCopies(updatedBook.getAvailableCopies());
//        book.setTotalCopies(updatedBook.getTotalCopies());
//        book.setBookCover(updatedBook.getBookCover());
//        book.setPdfFile(updatedBook.getPdfFile());
//        book.setAudioFile(updatedBook.getAudioFile());
//        book.setCategory(updatedBook.getCategory());
//
//        if (updatedBook.getCategory() == null || updatedBook.getCategory().getId() == null) {
//            throw new IllegalArgumentException("Category is required");
//        }
//        Long categoryId = updatedBook.getCategory().getId();
//        Category category = categoryRepo.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
//        book.setCategory(category);
//
//        return bookRepo.save(book);
//    }
//    @Override
//    public void deleteBook(Long id) {
//        bookRepo.deleteById(id);
//    }
//
//}
