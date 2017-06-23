package com.crud.daos.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;

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
	public List<ItemModel> getItemsByStartAndLimit(final int start, final int limit) {
		int newLimit = limit <= 0 ? -1 : limit;
		DetachedCriteria criteria = DetachedCriteria.forClass(ItemModel.class);
		return (List<ItemModel>) hibernateTemplate.findByCriteria(criteria, start, newLimit);
	}

	@Override
	public ItemModel getItemById(int id) {
		return hibernateTemplate.get(ItemModel.class, id);
	}

	@Override
	public boolean deleteItemById(int itemId) throws DataAccessException {
		ItemModel toBeDeleted = getItemById(itemId);
		if (toBeDeleted != null) {
			hibernateTemplate.delete(toBeDeleted);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertOrUpdateItem(ItemModel item) throws DataAccessException {
		hibernateTemplate.saveOrUpdate(item);
		return true;
	}

}
