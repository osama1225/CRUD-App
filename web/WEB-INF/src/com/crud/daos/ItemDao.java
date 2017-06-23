package com.crud.daos;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crud.hibernate.models.ItemModel;

public interface ItemDao {

	List<ItemModel> getAllItems();
	
	List<ItemModel> getItemsByStartAndLimit(int start, int limit);

	ItemModel getItemById(int id);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = -1)
	boolean deleteItemById(int itemId) throws DataAccessException;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = -1)
	boolean insertOrUpdateItem(ItemModel item) throws DataAccessException;
	

}
