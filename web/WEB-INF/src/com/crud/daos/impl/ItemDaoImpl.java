package com.crud.daos.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.crud.daos.ItemDao;
import com.crud.hibernate.beans.Item;

public class ItemDaoImpl implements ItemDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Item> getAllItems() {
		return hibernateTemplate.loadAll(Item.class);
	}

}
