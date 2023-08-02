package com.jeffreysy.microjpa.Transaction;

import java.time.LocalDate;

import com.jeffreysy.microjpa.Book.Book;
import com.jeffreysy.microjpa.Customer.Customer;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer_id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book_id;

    @NotBlank
    private LocalDate transaction_date;

    @NotBlank
    private String transactionType;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public Book getBook_id() {
		return book_id;
	}

	public void setBook_id(Book book_id) {
		this.book_id = book_id;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_type() {
		return transactionType;
	}

	public void setTransaction_type(String transaction_type) {
		this.transactionType = transaction_type;
	}
	
	public Transaction() {}

	public Transaction(Long transactionId, Customer customer_id, Book book_id, @NotBlank LocalDate transaction_date,
			@NotBlank String transaction_type) {
		super();
		this.transactionId = transactionId;
		this.customer_id = customer_id;
		this.book_id = book_id;
		this.transaction_date = transaction_date;
		this.transactionType = transaction_type;
	}
	
	
    
	
}

