package com.crud.daos;

import java.util.List;

import com.crud.hibernate.beans.Item;

public interface ItemDao {

	List<Item> getAllItems();
}
