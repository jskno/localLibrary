package es.library.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.everis.library.ejb.ItemService;
import es.library.model.ItemData;

@Named("itemController")
@SessionScoped
public class ItemController implements Serializable {

   private static final long serialVersionUID = 1L;

   @Inject
   private ItemData itemData;
   
   @EJB
   private ItemService itemService;

   public String addEntity(){
	   itemService.updateEntity(ItemData.fromData(itemData));
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