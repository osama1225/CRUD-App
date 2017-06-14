package com.crud.facades;

import java.util.List;

import com.crud.dtos.ItemDTO;

public interface ItemFacade {

	List<ItemDTO> getAllItems();
	
	ItemDTO getItemById(int id);
	
}
