package com.crud.daos;

import java.util.List;

import com.crud.hibernate.models.ItemModel;

public interface ItemDao {

	List<ItemModel> getAllItems();

	ItemModel getItemById(int id);
}
