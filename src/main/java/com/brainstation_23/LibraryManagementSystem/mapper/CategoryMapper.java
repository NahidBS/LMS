package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.CategoryDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO dto);
}