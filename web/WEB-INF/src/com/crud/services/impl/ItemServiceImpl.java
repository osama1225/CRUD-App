package com.crud.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.crud.daos.ItemDao;
import com.crud.hibernate.models.ItemModel;
import com.crud.services.ItemService;

public class ItemServiceImpl implements ItemService,InitializingBean {

	@Resource
	private ItemDao itemDao;
	
	@Override
	public List<ItemModel> getAllItems() {
		return itemDao.getAllItems();
	}
	
	@Override
	public ItemModel getItemById(int id) {
		return itemDao.getItemById(id);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(itemDao == null){
			throw new Exception("itemDao not set");
		}
	}


}
