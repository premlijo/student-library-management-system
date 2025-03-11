package com.firstproject.student_library_management_system.controller;

import com.firstproject.student_library_management_system.model.Transaction;
import com.firstproject.student_library_management_system.requestdto.TransactionRequestDto;
import com.firstproject.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        try {
            String response = transactionService.saveTransaction(transactionRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findTransactionById(@PathVariable int id){
        try {
            Transaction transaction = transactionService.findTransactionById(id);
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAllTransaction(){
        try {
            List<Transaction> transactionList = transactionService.findAllTransaction();
            return ResponseEntity.ok(transactionList);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable int id, @RequestBody TransactionRequestDto transactionRequestDto){
        try {
            String response = transactionService.updateTransaction(id, transactionRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTransactionById(@PathVariable int id){
        try {
            String response = transactionService.deleteTransactionById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some exception occurred : " + e.getMessage());
        }
    }
}
