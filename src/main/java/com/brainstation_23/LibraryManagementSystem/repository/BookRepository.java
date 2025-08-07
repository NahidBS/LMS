package com.brainstation_23.LibraryManagementSystem.repository;

import com.brainstation_23.LibraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
