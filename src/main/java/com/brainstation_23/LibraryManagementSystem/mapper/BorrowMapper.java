package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.BorrowDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Borrow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    BorrowDTO toDTO(Borrow borrow);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "bookId", target = "book.id")
    Borrow toEntity(BorrowDTO dto);
}
