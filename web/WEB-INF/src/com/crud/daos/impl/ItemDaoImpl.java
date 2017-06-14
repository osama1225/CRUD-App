package com.crud.daos.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.crud.daos.ItemDao;
import com.crud.hibernate.models.ItemModel;

public class ItemDaoImpl implements ItemDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<ItemModel> getAllItems() {
		return hibernateTemplate.loadAll(ItemModel.class);
	}

	@Override
	public ItemModel getItemById(int id) {
		return hibernateTemplate.get(ItemModel.class, id);
	}

}
