package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> bookListrest() {
		return (List<Category>) categoryRepository.findAll();
	}

	@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findBookRest(@PathVariable("id") Long catId) {
		return categoryRepository.findById(catId);
	}
	
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Category saveCatRest(@RequestBody Category category) {	
    	return categoryRepository.save(category);
    }
	
	
	
	
	
	@RequestMapping(value = "/categorylist")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";	
	}
	
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory")
	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:/categorylist";
	}
}