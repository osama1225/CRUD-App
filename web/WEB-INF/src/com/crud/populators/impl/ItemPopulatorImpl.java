package com.crud.populators.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.crud.dtos.ItemDTO;
import com.crud.hibernate.models.ItemModel;
import com.crud.populators.ItemPopulator;

public class ItemPopulatorImpl implements ItemPopulator {

	@Override
	public ItemDTO populate(ItemModel itemModel) {
		ItemDTO itemDTO = new ItemDTO();
		if (itemModel != null) {
			itemDTO.setId(itemModel.getId());
			itemDTO.setName(itemModel.getName());
			itemDTO.setDescription(itemModel.getDescription());
			itemDTO.setImageUrl(itemModel.getImageUrl());
			return itemDTO;
		}
		return null;
	}

	@Override
	public List<ItemDTO> populateAll(List<ItemModel> itemModels) {
		List<ItemDTO> result = new ArrayList<>();
		if (!CollectionUtils.isEmpty(itemModels)) {
			for (ItemModel itemModel : itemModels) {
				ItemDTO itemDTO = populate(itemModel);
				result.add(itemDTO);
			}
		}
		return result;
	}

	@Override
	public ItemModel convertToModel(ItemDTO itemDTO) {
		if (itemDTO == null){
			return null;
		}
		ItemModel itemModel = new ItemModel();
		itemModel.setId(itemDTO.getId());
		itemModel.setName(itemDTO.getName());
		itemModel.setDescription(itemDTO.getDescription());
		itemModel.setImageUrl(itemDTO.getImageUrl());
		return itemModel;
	}

}
