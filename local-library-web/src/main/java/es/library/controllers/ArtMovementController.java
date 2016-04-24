package es.library.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import es.everis.library.ejb.ArtMovementService;
import es.library.model.ArtMovementData;

@Named("artMovementController")
@SessionScoped
//@Model
public class ArtMovementController implements Serializable {

   private static final long serialVersionUID = 1L;

   @Inject
   private ArtMovementData artMovemenData;
   
   @EJB
   private ArtMovementService artMovementService;

   public String addEntity(){
	   
	  artMovementService.addEntity(ArtMovementData.fromData(artMovemenData));
      return "movement";
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