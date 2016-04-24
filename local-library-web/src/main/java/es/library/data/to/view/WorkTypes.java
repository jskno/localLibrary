package es.library.data.to.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class WorkTypes implements Serializable {

   private static final long serialVersionUID = 1L;

   private List<String> types;

   public WorkTypes() {
	   types = new ArrayList<String>();
	   types.add("BOOK");
	   types.add("FILM");
   }
   public List<String> getTypes() {
      return types;
   }

   public void setTypes(List<String> types) {
	   this.types = types;
   }

}
