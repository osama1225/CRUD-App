package com.crud.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;

import com.crud.daos.ItemDao;
import com.crud.hibernate.models.ItemModel;
import com.crud.services.ItemService;

public class ItemServiceImpl implements ItemService, InitializingBean {

	@Resource
	private ItemDao itemDao;

	@Value("${max.items.per.page}")
	private String maxItemsPerPageProperty;

	private int maxItemsPerPage;

	@Override
	public List<ItemModel> getAllItems() {
		return itemDao.getAllItems();
	}

	@Override
	public List<ItemModel> getPaginatedItems(int pageNumber) {
		int start = calculateFirstItemNumberInPage(pageNumber, getMaxItemsPerPage());
		return itemDao.getItemsByStartAndLimit(start, getMaxItemsPerPage());
	}

	private int calculateFirstItemNumberInPage(int pageNumber, int itemsPerPage) {
		if (pageNumber <= 0 || itemsPerPage <= 0) {
			return 0;
		}
		return (pageNumber * itemsPerPage) - itemsPerPage;
	}

	@Override
	public ItemModel getItemById(int id) {
		return itemDao.getItemById(id);
	}

	public int getMaxItemsPerPage() {
		if (maxItemsPerPage == 0) {
			if (StringUtils.isEmpty(maxItemsPerPageProperty)) {
				maxItemsPerPage = -1;
			} else {
				maxItemsPerPage = Integer.parseInt(maxItemsPerPageProperty);
			}
		}
		return maxItemsPerPage;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (itemDao == null) {
			throw new Exception("itemDao not set");
		}
	}

	@Override
	public boolean deleteItemById(int itemId) {
		if (itemId > 0) {
			try {
				return itemDao.deleteItemById(itemId);
			} catch (DataAccessException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean addOrUpdateItem(ItemModel itemModel) {
		if (itemModel != null){
			try {
				return itemDao.insertOrUpdateItem(itemModel);
			} catch (DataAccessException e) {
				return false;
			}
		}
		return false;
	}

}
