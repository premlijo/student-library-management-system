package com.firstproject.student_library_management_system.controller;


import com.firstproject.student_library_management_system.model.Author;
import com.firstproject.student_library_management_system.requestdto.AuthorRequestDto;
import com.firstproject.student_library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        try {
            String response = authorService.saveAuthor(authorRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findAuthorById(@PathVariable int id){
        try {
            Author author = authorService.findAuthorById(id);
            return ResponseEntity.ok(author);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllAuthor() {
        try {
            List<Author> authorList = authorService.findAllAuthor();
            return ResponseEntity.ok(authorList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthorById(@PathVariable int id, @RequestBody AuthorRequestDto authorRequestDto){
        try {
            String response = authorService.updateAuthorById(id, authorRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthorById(@PathVariable int id){
        try {
            String response = authorService.deleteAuthorById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }
}
