package hh.swd20.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.Bookstore.web.BookController;
import hh.swd20.Bookstore.web.CategoryController;

@ExtendWith(SpringExtension.class) 
@SpringBootTest

public class SmokeTestControllers {
	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Test
	public void contextLoadsBookController() throws Exception {
		assertThat(bookController).isNotNull();
	}
	
	@Test
	public void contextLoadsCategoryController() throws Exception {
		assertThat(categoryController).isNotNull();
	}
	

}
