package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.dto.request.CategoryRequestDTO;
import com.brainstation_23.LibraryManagementSystem.dto.response.CategoryResponseDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepo;

    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        if (categoryRepo.findByName(request.getName()).isPresent()) {
            throw new RuntimeException("Category already exists.");
        }
        
        Category category = Category.builder()
                .name(request.getName())
                .build();
        
        Category saved = categoryRepo.save(category);
        return mapToResponseDTO(saved);
    }

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepo.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO request) {
        Category existing = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        existing.setName(request.getName());
        Category saved = categoryRepo.save(existing);
        return mapToResponseDTO(saved);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }
    
    private CategoryResponseDTO mapToResponseDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setCreatedAt(category.getCreatedAt());
        dto.setUpdatedAt(category.getUpdatedAt());
        return dto;
    }

}
