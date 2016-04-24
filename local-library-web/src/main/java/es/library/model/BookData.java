package es.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.Book;

@Model
public class BookData extends WorkData {
	
	private String trick;
	
	public String getTrick() {
		return trick;
	}
	public void setTrick(String trick) {
		this.trick = trick;
	}
	
	public Book fromData() {
		Book book = new Book();
		super.fromData(book);
		book.setTrick(getTrick());
		return book;
	}

	public BookData toData(Book book) {
		BookData bookData = new BookData();
		super.toData(book);
		bookData.setTrick(book.getTrick());
		return bookData;
	}
	
	public List<BookData> toData(List<Book> books) {
		List<BookData> booksData = new ArrayList<BookData>();
		for(Book book : books) {
			booksData.add(toData(book));
		}
		return booksData;
	}
}
