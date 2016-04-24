package es.library.data.to.view;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import es.everis.library.entity.business.Format;

@Named
@ApplicationScoped
public class FormatTypes {

	public Format[] getFormats() {
		return Format.values();
	}
   

}
