package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.UserRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books and categories");
			
			Category categoryFiction = new Category("Fiction");
			categoryRepository.save(categoryFiction);
			Category categoryKids = new Category("Kids");
			categoryRepository.save(categoryKids);
			Category categoryNinFiction = new Category("Non-fiction");
			categoryRepository.save(categoryNinFiction);
			
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123-12", categoryFiction));
			bookRepository.save(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, "12345456778-23", categoryKids));
			
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("fetch all categories");
			for (Category category: categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@book.fi");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "email@book.fi");
			urepository.save(user1);
			urepository.save(user2);
				log.info("users created: " + user1.getRole() + user2.getRole());
		};
	}
	

}
