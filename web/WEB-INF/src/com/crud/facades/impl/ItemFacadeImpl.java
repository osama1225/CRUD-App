package com.crud.facades.impl;

import java.util.List;

import javax.annotation.Resource;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;
import com.crud.hibernate.models.ItemModel;
import com.crud.populators.ItemPopulator;
import com.crud.services.ItemService;

public class ItemFacadeImpl implements ItemFacade {

	@Resource
	private ItemService itemService;

	@Resource
	private ItemPopulator itemPopulator;

	@Override
	public List<ItemDTO> getAllItems() {
		List<ItemModel> itemModels = itemService.getAllItems();
		List<ItemDTO> itemDTOs = itemPopulator.populateAll(itemModels);
		return itemDTOs;
	}

	@Override
	public ItemDTO getItemById(int id) {
		ItemModel itemModel = itemService.getItemById(id);
		ItemDTO itemDTO = itemPopulator.populate(itemModel);
		return itemDTO;
	}

}
