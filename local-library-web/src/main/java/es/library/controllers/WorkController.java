package es.library.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.everis.library.ejb.ArtMovementService;
import es.everis.library.ejb.BookService;
import es.everis.library.ejb.CategoryService;
import es.everis.library.ejb.FilmService;
import es.everis.library.entity.business.Book;
import es.everis.library.entity.business.Film;
import es.everis.library.entity.business.WorkType;
import es.library.model.GralWorkData;

@Named("workController")
@SessionScoped
public class WorkController implements Serializable {

   private static final long serialVersionUID = 1L;

   @Inject
   private GralWorkData gralWorkData;
   
   @EJB
   private BookService bookService;
   @EJB
   private FilmService filmService;
   @EJB
   private ArtMovementService artMovementService;
   @EJB
   private CategoryService categoryService;

   public String addEntity(){
	  if(WorkType.BOOK.toString().equals(gralWorkData.getWorkType())) {
		  bookService.addEntity((Book) gralWorkData.fromData());
	  } 
	  else if(WorkType.FILM.toString().equals(gralWorkData.getWorkType())) {
		  filmService.addEntity((Film) gralWorkData.fromData());
	  }
      return "work";
   }

}