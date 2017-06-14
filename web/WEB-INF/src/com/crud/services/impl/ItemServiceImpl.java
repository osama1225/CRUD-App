package com.crud.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.crud.daos.ItemDao;
import com.crud.hibernate.beans.Item;
import com.crud.services.ItemService;

public class ItemServiceImpl implements ItemService,InitializingBean {

	@Resource
	private ItemDao itemDao;
	
	@Override
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(itemDao == null){
			throw new Exception("itemDao not set");
		}
	}

}
