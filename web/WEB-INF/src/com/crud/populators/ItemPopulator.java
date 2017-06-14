package com.crud.populators;

import java.util.List;

import com.crud.dtos.ItemDTO;
import com.crud.hibernate.models.ItemModel;

public interface ItemPopulator {

	public ItemDTO populate(ItemModel itemModel);
	
	public List<ItemDTO> populateAll(List<ItemModel> itemModels);
	
}
