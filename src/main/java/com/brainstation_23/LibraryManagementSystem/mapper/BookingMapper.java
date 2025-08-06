package com.brainstation_23.LibraryManagementSystem.mapper;

import com.brainstation_23.LibraryManagementSystem.dto.BookingDTO;
import com.brainstation_23.LibraryManagementSystem.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "book.id", target = "bookId")
    BookingDTO toDTO(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "bookId", target = "book.id")
    Booking toEntity(BookingDTO dto);
}