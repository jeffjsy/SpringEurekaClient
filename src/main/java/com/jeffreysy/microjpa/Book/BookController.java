package com.jeffreysy.microjpa.Book;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }
    
    @GetMapping("/new")
    public String showBookCreationForm(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }
    
    @GetMapping("/list")
    public String showBookList(Model model) {
    	List<Book> books = bookRepository.findAll();
    	model.addAttribute("books", books);
    	return "books";
    }
    
    @GetMapping("/availability")
    public String showAvailabilityPage() {
    	return "availability";
    }
    
    @PostMapping("/checkAvailability")
    public String checkAvailability(@RequestParam("bookName") String bookName, Model model) {
    	boolean isAvailable = bookService.isBookAvailable(bookName);
    	model.addAttribute("bookName", bookName);
    	model.addAttribute("availability", isAvailable);
    	return "availability";
    }

    // Create a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    
    
    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    } 
    
    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    
    
}
