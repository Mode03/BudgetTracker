package com.app.budgetTracker.repos;

import com.app.budgetTracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {

}
