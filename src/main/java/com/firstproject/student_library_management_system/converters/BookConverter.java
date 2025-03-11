package com.firstproject.student_library_management_system.converters;

import com.firstproject.student_library_management_system.model.Book;
import com.firstproject.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto) {

        Book book = new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setPages(bookRequestDto.getPages());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setCategory(bookRequestDto.getCategory());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setAvailability(bookRequestDto.isAvailability());

        return book;
    }
}
