package com.firstproject.student_library_management_system.service;

import com.firstproject.student_library_management_system.converters.TransactionConverter;
import com.firstproject.student_library_management_system.model.Book;
import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.model.Transaction;
import com.firstproject.student_library_management_system.repository.BookRepository;
import com.firstproject.student_library_management_system.repository.CardRepository;
import com.firstproject.student_library_management_system.repository.TransactionRepository;
import com.firstproject.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction = TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);
        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);
        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);

        return "Transaction saved successfully";
    }

    public Transaction findTransactionById(int id){
        Optional<Transaction> optionalTransaction= transactionRepository.findById(id);
        if(optionalTransaction.isPresent()){
            return optionalTransaction.get();
        }else {
            throw new RuntimeException("Transaction not found with id : "+ id);
        }
    }

    public List<Transaction> findAllTransaction(){
        List<Transaction> transactionList = transactionRepository.findAll();
        return transactionList;
    }

    public String updateTransaction(int id, TransactionRequestDto transactionRequestDto){
        Transaction transaction = findTransactionById(id);

        if(transaction !=  null){
            transaction.setTransactionType(transactionRequestDto.getTransactionType());
            transaction.setDueDate(transactionRequestDto.getDueDate());
            transaction.setFine(transactionRequestDto.getFine());
            transactionRepository.save(transaction);
            return "Transaction updated successfully";
        } else {
            return "Transaction cannot be updated";
        }
    }

    public String deleteTransactionById(int id){
        transactionRepository.deleteById(id);
        return "Transaction deleted successfully";
    }

}
