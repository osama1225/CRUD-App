package com.crud.webservices.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;

@RestController
@RequestMapping("/rest/")
public class ItemRestController {

	@Resource
	private ItemFacade itemFacade;

	@RequestMapping("list-items")
	public List<ItemDTO> listItems() {
		return itemFacade.getAllItems();
	}
	
	@RequestMapping("item/{itemId}")
	public ItemDTO getItem(@PathVariable int itemId) {
		return itemFacade.getItemById(itemId);
	}
	
	

}
