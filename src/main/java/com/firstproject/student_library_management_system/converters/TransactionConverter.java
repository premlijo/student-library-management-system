package com.firstproject.student_library_management_system.converters;

import com.firstproject.student_library_management_system.model.Transaction;
import com.firstproject.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){

        Transaction transaction = new Transaction();

        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setFine(transactionRequestDto.getFine());

        return transaction;
    }

}
