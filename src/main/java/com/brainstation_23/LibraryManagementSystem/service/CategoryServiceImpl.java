package com.brainstation_23.LibraryManagementSystem.service;

import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepo;

    public Category createCategory(Category category) {
        if (categoryRepo.findByCategoryName(category.getCategoryName()).isPresent()) {
            throw new RuntimeException("Category already exists.");
        }
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existing = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        existing.setCategoryName(updatedCategory.getCategoryName());
        return categoryRepo.save(existing);
    }

    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);
    }

}
