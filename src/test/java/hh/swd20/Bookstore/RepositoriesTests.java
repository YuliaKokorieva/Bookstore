package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class RepositoriesTests {
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository catrepository;
	
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("A Farewell to Arms");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1967, "12345", null);
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
//	@Test
//	public void deleteBook() {
//		
//	}
//	

	@Test
	public void findByCatNameShouldReturnCategory() {
		List<Category> categories = catrepository.findByCategoryName("Fiction");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryID()).isEqualTo(1);
	}
	
	@Test
	public void createNewCategory() {
		Category cat= new Category("Science");
		catrepository.save(cat);
		assertThat(cat.getCategoryID()).isNotNull();
	}
	
}


