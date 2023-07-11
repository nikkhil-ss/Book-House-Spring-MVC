package com.service;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.exception.InvalidBookException;
import com.model.Book;

//use appropriate annotation to configure BookService as a Service
@Service
public class BookService {
	private ArrayList<Book> bookList = new ArrayList<Book>();

	// Validate ISBN and add Book object into the bookList
	public boolean addBook(Book book) throws InvalidBookException {
		// fill the code
		for (Book b : bookList) {
			if (b.getIsbn().equals(book.getIsbn())) {
				throw new InvalidBookException("Book with ISBN " + book.getIsbn() + " already exists!");
			}
		}
		bookList.add(book);
		return true;
	}

	public ArrayList<Book> viewAllBooks() {
		// fill the code
		return bookList;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> list) {
		this.bookList = list;
	}

	

}
