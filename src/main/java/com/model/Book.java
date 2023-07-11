package com.model;

import org.springframework.stereotype.Component;

//use appropriate annotation to make this class as a component class
@Component
public class Book {
	// fill the code
	
	private String isbn;
	// fill the code
	private String bookName;
	// fill the code
	private int quantity;
	private String category;
	// fill the code
	private int price;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Book() {
	}
}
