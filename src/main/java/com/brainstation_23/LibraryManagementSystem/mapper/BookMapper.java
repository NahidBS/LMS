package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.BookDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Book;
import com.brainstation_23.LibraryManagementSystem.entity.Category;
import com.brainstation_23.LibraryManagementSystem.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring" , uses = {CategoryResolver.class})
//public abstract class BookMapper {
public interface BookMapper{
    @Autowired
//    protected CategoryResolver categoryResolver;

    // Entity (Book) → DTO (BookDTO)
    @Mapping(source = "category.id", target = "categoryId")
//    public abstract BookDTO toDTO(Book book);
    BookDTO toDTO(Book book);

    // DTO (BookDTO) → Entity (Book)
    @Mapping(source = "categoryId", target = "category")
//    public abstract Book toEntity(BookDTO dto);
    Book toEntity(BookDTO bookDTO);

//    @Named("resolveCategory")
//    public Category mapCategory(Long categoryId){
//        return categoryResolver.map(categoryId);
//    }

//    public static class CategoryResolver{
//        @Autowired
//        private CategoryRepository categoryRepo;
//        public Category resolve(Long id){
//            return categoryRepo.findById(id).orElse(null);
//        }
//    }
}
