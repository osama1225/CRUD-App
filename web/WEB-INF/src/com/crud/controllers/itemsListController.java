package com.crud.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;

/**
 * 
 * @author Mohamed
 *
 */
@Controller
@RequestMapping(value = "/list")
public class itemsListController {

	@Resource
	private ItemFacade itemFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showItems(final Model model) {
		List<ItemDTO> items = itemFacade.getAllItems();
		model.addAttribute("items", items);
		return "list-view";
	}

}
