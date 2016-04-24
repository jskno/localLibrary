package es.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;

import es.everis.library.entity.business.Book;
import es.everis.library.entity.business.Film;
import es.everis.library.entity.business.Format;
import es.everis.library.entity.business.Item;
import es.everis.library.entity.business.Work;
import es.everis.library.entity.business.WorkType;

@Model
public class ItemData {
	
	private Integer itemId;
	private Integer workId;
	private String formatType;
	private String workType;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	public static Item fromData(ItemData itemData) {
		if (itemData == null) {
			return null;
		}
		Item item = new Item();
		item.setItemId(itemData.getItemId());
		Work work = null;
		if(WorkType.BOOK.label().equals(itemData.getWorkType())) {
			work = new Book();
		} else if(WorkType.FILM.label().equals(itemData.getWorkType())) {
			work = new Film();
		}
		work.setWorkId(itemData.getWorkId());
		item.setWork(work);
		item.setFormat(Format.valueOf(itemData.getFormatType().toUpperCase()));
		return item;
	}
	
	public static ItemData toData(Item item) {
		if (item == null) {
			return null;
		}
		ItemData itemData = new ItemData();
		itemData.setItemId(item.getItemId());
		itemData.setWorkId(item.getWork().getWorkId());
		itemData.setFormatType(item.getFormat().label());
		if(WorkType.BOOK == item.getFormat().workType()) {
			itemData.setWorkType(WorkType.BOOK.label());
		} else if(WorkType.FILM == item.getFormat().workType()) {
			itemData.setWorkType(WorkType.FILM.label());
		}
		return itemData;
	}
	
	public static List<ItemData> toData(List<Item> items) {
		if(items == null || items.isEmpty()) {
			return null;
		}
		List<ItemData> itemsData = new ArrayList<ItemData>();
		for(Item item : items) {
			itemsData.add(toData(item));
		}
		return itemsData;
	}

}
