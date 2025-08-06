package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryResolver {
    @Autowired
    private CategoryRepository categoryRepo;

    @Named("categoryFromId")
    public Category map(Long id) {
        if (id == null) return null;
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }
}


