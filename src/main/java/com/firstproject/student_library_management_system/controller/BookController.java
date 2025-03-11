package com.firstproject.student_library_management_system.controller;

import com.firstproject.student_library_management_system.model.Book;
import com.firstproject.student_library_management_system.requestdto.BookRequestDto;
import com.firstproject.student_library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookRequestDto bookRequestDto){
        try {
            String response = bookService.saveBook(bookRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllBook(){
        try {
            List<Book> bookList = bookService.findAllBook();
            return ResponseEntity.ok(bookList);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findBookById(@PathVariable int id){
            try {
                Book book = bookService.findBookById(id);
                return ResponseEntity.ok(book);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
            }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id){
        try {
            String response = bookService.deleteBookById(id);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody BookRequestDto bookRequestDto){
        try {
            String response = bookService.updateBook(id, bookRequestDto);
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }
}
