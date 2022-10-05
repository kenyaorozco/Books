package com.kenya.bookapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kenya.bookapi.models.Book;
import com.kenya.bookapi.repos.BookRepository;

@Service
public class BookService {
	
	 private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    // delete by id
	    public void deleteById(Long id) {
	    	bookRepository.deleteById(id); 	
	    }

	    //update book by ID
	    public Book updateBook( Long id, String title, String desc, String lang, Integer numOfPages ){
	    	Book book = bookRepository.findById(id).get();
	    	book.setTitle(title);
	    	book.setDescription(desc);
	    	book.setLanguage(lang);
	    	book.setNumberOfPages(numOfPages);
	    	
	    	return bookRepository.save(book);
	    }
	

}
