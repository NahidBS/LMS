package com.brainstation_23.LibraryManagementSystem.repository;

import com.brainstation_23.LibraryManagementSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
