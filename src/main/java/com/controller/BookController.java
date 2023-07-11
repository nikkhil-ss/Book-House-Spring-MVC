package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exception.InvalidBookException;
import com.model.Book;
import com.service.BookService;

//use appropriate annotation to configure BookController as Controller
@Controller
public class BookController {

	// use appropriate annotation
	@Autowired
	private BookService bookService;

	// invoke the service class - addBook method.
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

	@RequestMapping("/index")
	public String indexPage2() {
		return "index";
	}

	@RequestMapping(value = "/showPage", method = RequestMethod.GET)
	public String showPage(@ModelAttribute("book") Book book, Model model, BindingResult result) {
//		ModelAndView model1=new ModelAndView("showPage");
//		Map<String, String> bookCategoryList =populateBooKCategory();
//		model.addAttribute("bookCategory",bookCategoryList);
//		model.addAttribute("book",new Book());

		return "showPage";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") Book book, BindingResult result, ModelMap model)
			throws InvalidBookException {
		try {
			boolean added = bookService.addBook(book);

			if (added) {
				model.addAttribute("message", "Book added successfully");
			}
		} catch (InvalidBookException e) {
			model.addAttribute("exception", "Book with ISBN " + book.getIsbn() + " already exists!");
			return "exceptionPage";
		}
		return "showPage";
		// fill the code
	}

	// fill the code
	@GetMapping("/viewList")
	public String viewAllBooks(@ModelAttribute("book") Book book, ModelMap model) {

		// fill the code

		List<Book> bookList = bookService.viewAllBooks();
		model.addAttribute("bookList", bookList);

		return "viewList";

	}

	@ModelAttribute("bookCategory")
	public Map<String, String> populateBookCategory() {

		Map<String, String> bookCategoryList = new HashMap<String, String>();
		bookCategoryList.put("Science", "Science");
		bookCategoryList.put("Humor", "Humor");
		bookCategoryList.put("Novel", "Novel");
		bookCategoryList.put("Health", "Health");
		bookCategoryList.put("Travel", "Travel");
		bookCategoryList.put("Motivational", "Motivational");
		bookCategoryList.put("Art", "Art");
		bookCategoryList.put("Encyclopedia", "Encyclopedia");
		bookCategoryList.put("Biography", "Biography");
		bookCategoryList.put("Cooking", "Cooking");

		return bookCategoryList;

	}

	// Use appropriate annotation
	@ExceptionHandler(InvalidBookException.class)
	public String exceptionHandler(InvalidBookException e) {
		ModelAndView model = new ModelAndView("exceptionPage");
		model.setViewName("exceptionPage");
		model.addObject("message", e.getMessage());
		// fill the code
		return "exceptionPage";
	}

}
