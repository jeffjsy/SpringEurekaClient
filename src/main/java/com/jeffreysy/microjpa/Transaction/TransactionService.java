package com.jeffreysy.microjpa.Transaction;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffreysy.microjpa.Book.Book;
import com.jeffreysy.microjpa.Book.BookRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        return optionalTransaction.orElse(null);
    }
    
    // Get Borrowed books
    public List<Transaction> getBorrowedBooks() {
    	return transactionRepository.findByTransactionType("Borrow");
    }
}
