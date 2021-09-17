package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.Bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/booklist")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";	
	}
		

}
