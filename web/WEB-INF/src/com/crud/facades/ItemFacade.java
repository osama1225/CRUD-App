package com.crud.facades;

import java.util.List;

import com.crud.dtos.ItemDTO;

public interface ItemFacade {

	List<ItemDTO> getAllItems();
	
	List<ItemDTO> getPaginatedItems(int pageNumber);
	
	ItemDTO getItemById(int id);

	boolean deleteItem(int itemId);
	
}
