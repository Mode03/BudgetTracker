package com.app.budgetTracker.services;

import com.app.budgetTracker.models.Transaction;
import com.app.budgetTracker.repos.TransactionRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public void createTransaction(String type, double amount, LocalDate date) {
        Transaction transaction = new Transaction();
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setDate(date);
        transactionRepo.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepo.deleteById(id);
    }
}
