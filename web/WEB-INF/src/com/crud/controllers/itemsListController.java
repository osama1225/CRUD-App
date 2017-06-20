package com.crud.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;

/**
 * 
 * @author Mohamed
 *
 */
@Controller
public class itemsListController {

	@Resource
	private ItemFacade itemFacade;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showItems(final Model model) {
		List<ItemDTO> items = itemFacade.getAllItems();
		model.addAttribute("items", items);
		return "list-view";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteItem(@RequestParam(name="id") int id) {
		return itemFacade.deleteItem(id);
	}

}
