package com.firstproject.student_library_management_system.controller;

import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.requestdto.CardRequestDto;
import com.firstproject.student_library_management_system.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/api")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCard(@RequestBody CardRequestDto cardRequestDto){
        try {
            String response = cardService.saveCard(cardRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : "+ e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findCardById(@PathVariable int id){
        try {
            Card card = cardService.findCardById(id);
            return ResponseEntity.ok(card);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : "+ e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllCards(){
        try {
            List<Card> cardList = cardService.findAllCards();
            return ResponseEntity.ok(cardList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : "+ e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCardById(@PathVariable int id){
        try {
            String response = cardService.deleteCardById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : "+ e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody CardRequestDto cardRequestDto){
        try {
            String response = cardService.updateCard(id, cardRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : "+ e.getMessage());
        }
    }
}
