package com.jeffreysy.microjpa.Transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }
    
    @GetMapping("/new")
    public String showTransactionCreationForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "newTransaction";
    }
    
    @GetMapping("/list")
    public String showBookList(Model model) {
    	List<Transaction> transactions = transactionRepository.findAll();
    	model.addAttribute("transactions", transactions);
    	return "transactions";
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }
    
    
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Get borrowed books
    public List<Transaction> getBorrowedBooks() {
    	return transactionService.getBorrowedBooks();
    }
    
    @GetMapping("/borrowed")
    public String showBorrowedBooks(Model model) {
    	List<Transaction> borrowedBooks= transactionService.getBorrowedBooks();
    	model.addAttribute("borrowedBooks", borrowedBooks);
    	return "borrowed-books";
    	
    }
}
