package es.library.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.everis.library.ejb.CategoryService;
import es.library.model.CategoryData;

@Named("categoryController")
@SessionScoped
public class CategoryController implements Serializable {

   private static final long serialVersionUID = 1L;

   @Inject
   private CategoryData categoryData;
   
   @EJB
   private CategoryService categoryService;

   public String addEntity(){
	  categoryService.updateEntity(CategoryData.fromData(categoryData));
      return "category";
   }

   public String moveToPage2(){
      return "page2";
   }

   public String moveToHomePage(){
      return "home";
   }

   public String processPage1(){
      return "page";
   }

   public String processPage2(){
      return "page";
   }

}