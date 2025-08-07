package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.CategoryRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.CategoryResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO request);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO request);
    void deleteCategory(Long id);
}
