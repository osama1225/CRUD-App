package com.crud.services;

import java.util.List;

import com.crud.hibernate.models.ItemModel;

public interface ItemService {

	List<ItemModel> getAllItems();
	
	ItemModel getItemById(int id);
	
}
