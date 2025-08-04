package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.BookDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BookMapper {
    @Autowired
    protected CategoryResolver categoryResolver;

    @Mapping(source = "categoryId", target = "category")
    public abstract BookDTO toDTO(Book book);

    @Named("resolveCategory")
    Category mapCategory(Long categoryId){
        return categoryResolver.resolve(categoryId);
    }

    public static class CategoryResolver{
        @Autowired
        private CategoryRepository categoryRepo;
        public Category resolve(Long id){
            return categoryRepo.findById(id).orElse(null);
        }
    }
}
