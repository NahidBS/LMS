package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    @Override
    public Book createBook(Book book){
        return  bookRepo.save(book);
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
        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


}
