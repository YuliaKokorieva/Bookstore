package hh.swd20.Bookstore.domain;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryID;
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<Book> books;
	
	public Category( ) {
		super();
		this.categoryName=null;	
	}
	
	public Category(String name) {
		super();
		this.categoryName=name;
	}


	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", name =" + categoryName + "]";
	}
	

}
