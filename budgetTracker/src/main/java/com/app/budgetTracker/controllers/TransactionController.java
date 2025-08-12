package com.app.budgetTracker.controllers;

import com.app.budgetTracker.models.Transaction;
import com.app.budgetTracker.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String getTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @PostMapping
    public String createTransaction(@RequestParam String type, @RequestParam double amount, @RequestParam LocalDate date) {
        transactionService.createTransaction(type, amount, date);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/";
    }
}
