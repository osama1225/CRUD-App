package com.crud.webservices.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;

@RestController
@RequestMapping("/rest/")
public class ItemRestController {

	@Resource
	private ItemFacade itemFacade;

	@RequestMapping("all")
	public List<ItemDTO> listAllItems() {
		return itemFacade.getAllItems();
	}
	
	@RequestMapping("items")
	public List<ItemDTO> listPaginatedItems(@RequestParam(name = "page") final int pageNumber) {
		return itemFacade.getPaginatedItems(pageNumber);
	}
	
	@RequestMapping("item/{itemId}")
	public ItemDTO getItem(@PathVariable int itemId) {
		return itemFacade.getItemById(itemId);
	}
	
}
