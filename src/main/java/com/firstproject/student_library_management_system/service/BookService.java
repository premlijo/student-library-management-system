package com.firstproject.student_library_management_system.service;

import com.firstproject.student_library_management_system.converters.BookConverter;
import com.firstproject.student_library_management_system.model.Author;
import com.firstproject.student_library_management_system.model.Book;
import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.repository.AuthorRepository;
import com.firstproject.student_library_management_system.repository.BookRepository;
import com.firstproject.student_library_management_system.repository.CardRepository;
import com.firstproject.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        bookRepository.save(book);

        return "Book saved successfully";
    }

    public List<Book> findAllBook(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book findBookById(int id){
        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        else{
            throw new RuntimeException("Book not found with id : "+ id);
        }
    }

    public String deleteBookById(int id){
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    public String updateBook(int id, BookRequestDto bookRequestDto){
        Book book = findBookById(id);

        if(book != null){
            book.setTitle(bookRequestDto.getTitle());
            book.setPublisherName(bookRequestDto.getPublisherName());
            book.setPublishedDate(bookRequestDto.getPublishedDate());
            book.setCategory(bookRequestDto.getCategory());
            book.setAvailability(bookRequestDto.isAvailability());
            book.setPages(bookRequestDto.getPages());
            book.setRackNo(bookRequestDto.getRackNo());

            bookRepository.save(book);
            return "Book updated successfully";
        }
        else {
            return "Book cannot be updated";
        }
    }
}
