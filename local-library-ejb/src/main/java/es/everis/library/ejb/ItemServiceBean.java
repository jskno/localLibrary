package es.everis.library.ejb;

import javax.ejb.Stateless;

import es.everis.library.entity.business.Item;

@Stateless
public class ItemServiceBean extends BaseServiceBean<Item> 
					implements ItemService {

}
