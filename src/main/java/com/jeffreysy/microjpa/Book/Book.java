package com.jeffreysy.microjpa.Book;

import java.util.List;

import com.jeffreysy.microjpa.Transaction.Transaction;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author's last name is required")
    private String author_lname;

    @NotBlank(message = "Author's first name is required")
    private String author_fname;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private int rating;
    
    @OneToMany(mappedBy = "book_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    
    public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor_lname() {
		return author_lname;
	}

	public void setAuthor_lname(String author_lname) {
		this.author_lname = author_lname;
	}

	public String getAuthor_fname() {
		return author_fname;
	}

	public void setAuthor_fname(String author_fname) {
		this.author_fname = author_fname;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

	public Book() {
    }

	public Book(Long book_id,
			@NotBlank(message = "Title is required") @Size(max = 255, message = "Title can have at most 255 characters") String title,
			@NotBlank(message = "Author's last name is required") @Size(max = 100, message = "Author's last name can have at most 100 characters") String author_lname,
			@NotBlank(message = "Author's first name is required") @Size(max = 100, message = "Author's first name can have at most 100 characters") String author_fname,
			@NotNull(message = "Rating is required") @Min(value = 1, message = "Rating must be at least 1") @Max(value = 5, message = "Rating must be at most 5") int rating) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author_lname = author_lname;
		this.author_fname = author_fname;
		this.rating = rating;
	}
    
	
    
   
}

