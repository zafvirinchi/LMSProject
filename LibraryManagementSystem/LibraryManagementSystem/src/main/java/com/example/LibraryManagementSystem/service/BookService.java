package com.example.LibraryManagementSystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.BookStatus;
import com.example.LibraryManagementSystem.Entity.BorrowingRecord;
import com.example.LibraryManagementSystem.Repo.BookRepository;
import com.example.LibraryManagementSystem.Repo.BorrowingRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
    private BorrowingRepository borrowingRepository;
	
	public List<Book> findAll() {
        return bookRepository.findAll();
    }
	
	 public Book findById(Long id) {
	    return bookRepository.findById(id).orElse(null);
	 }
	 
	 public Book save(Book book) {
	     return bookRepository.save(book);
	 }
	 
	 public BorrowingRecord save(BorrowingRecord boRecord) {
	     return borrowingRepository.save(boRecord);
	 }

	 public void deleteById(Long id) {
	     bookRepository.deleteById(id);
	 }
	 
		
	 public BorrowingRecord borrowBook(Long bookId, String user) {
	        Book book = findById(bookId);
	       // User user = userRepository.findById(userId).orElse(null);
	        BorrowingRecord boRecord = borrowingRepository.findByUser(user);
	        //BorrowingRecord boRecord = new BorrowingRecord();

	        if (book != null && user != null && book.getStatus()==BookStatus.AVAILABLE) {
	            book.setStatus(BookStatus.BORROWED);
	            boRecord.setUser(user);
	            boRecord.setBook(book);
	            boRecord.setBorrowingDate(LocalDate.now());
	           
	           
	            return save(boRecord);
	        }
	        return null;
	    }
	 
	 public BorrowingRecord returnBook(Long bookId,String user) {
	        Book book = findById(bookId);
	        
	        BorrowingRecord boRecord = borrowingRepository.findByUser(user);
	        
	        if (book != null && user != null) {
	        	   book.setStatus(BookStatus.AVAILABLE);
		            boRecord.setUser(user);
		            boRecord.setBook(book);
		            boRecord.setReturnDate(LocalDate.now());
	            return save(boRecord);
	        }
	        return null;
	    }
		 
}
