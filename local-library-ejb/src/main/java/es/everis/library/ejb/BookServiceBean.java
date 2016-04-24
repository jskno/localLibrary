package es.everis.library.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import es.everis.library.dao.BookDao;
import es.everis.library.entity.business.Book;

@Stateless
public class BookServiceBean extends WorkServiceBean<Book> 
				implements BookService {
	
	@EJB
//	@Inject @JPADAO 
	private BookDao bookDao;
	
	@PostConstruct
	public void setDaoToSuperClass() {
		super.setWorkDao(bookDao);
	}
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
