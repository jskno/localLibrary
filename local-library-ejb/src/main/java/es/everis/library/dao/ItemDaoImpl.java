package es.everis.library.dao;

import es.everis.library.entity.business.Item;

public class ItemDaoImpl extends BaseDaoImpl<Item> implements ItemDao {

	protected ItemDaoImpl() {
		super(Item.class);
	}

}
