package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;
    private final CategoryRepository categoryRepo;


    public BookServiceImpl(BookRepository bookRepo, CategoryRepository categoryRepo){
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
    }


    //
    @Override
    public Book createBook(Book book){
//        if (book.getCategory() == null || book.getCategory().getId() == null) {
//            // Fallback to default category
//            Category defaultCategory = categoryRepo.findByName("Uncategorized");
//            if (defaultCategory == null) {
//                throw new RuntimeException("Default category 'Uncategorized' not found.");
//            }
//            book.setCategory(defaultCategory);
//        } else {
//            Long categoryId = book.getCategory().getId();
//            Category category = categoryRepo.findById(categoryId)
//                    .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
//            book.setCategory(category);
//        }
//        return  bookRepo.save(book);
        if (book.getCategory() == null) {
            Category defaultCategory = categoryRepo.findByCategoryName("Uncategorized")
                    .orElseGet(() -> {
                        Category newCategory = new Category();
                        newCategory.setCategoryName("Uncategorized");
                        return categoryRepo.save(newCategory);
                    });
            book.setCategory(defaultCategory);
        } else {
            Long categoryId = book.getCategory().getId();
            Category category = categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
            book.setCategory(category);
        }
        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.empty();
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book book = bookRepo.findById(id).orElseThrow();
        book.setName(updatedBook.getName());
        book.setAuthor(updatedBook.getAuthor());
        book.setShortDescription(updatedBook.getShortDescription());
        book.setAvailableCopies(updatedBook.getAvailableCopies());
        book.setTotalCopies(updatedBook.getTotalCopies());
        book.setBookCover(updatedBook.getBookCover());
        book.setPdfFile(updatedBook.getPdfFile());
        book.setAudioFile(updatedBook.getAudioFile());
        book.setCategory(updatedBook.getCategory());

        if (updatedBook.getCategory() == null || updatedBook.getCategory().getId() == null) {
            throw new IllegalArgumentException("Category is required");
        }
        Long categoryId = updatedBook.getCategory().getId();
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
        book.setCategory(category);

        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


}
