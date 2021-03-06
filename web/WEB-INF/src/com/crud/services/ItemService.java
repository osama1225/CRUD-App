package com.crud.services;

import java.util.List;

import com.crud.hibernate.models.ItemModel;

public interface ItemService {

	List<ItemModel> getAllItems();
	
	List<ItemModel> getPaginatedItems(int pageNumber);
	
	ItemModel getItemById(int id);

	boolean deleteItemById(int itemId);
	
	boolean addOrUpdateItem(ItemModel itemModel);
	
}
