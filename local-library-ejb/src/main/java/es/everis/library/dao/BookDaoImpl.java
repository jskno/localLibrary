package es.everis.library.dao;

import javax.ejb.Stateless;

import es.everis.library.entity.business.Book;

@Stateless
public class BookDaoImpl extends WorkDaoImpl<Book> implements BookDao {

	public BookDaoImpl() {
		super(Book.class);
	}

}
