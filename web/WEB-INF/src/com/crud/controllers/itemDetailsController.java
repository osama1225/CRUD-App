package com.crud.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/detail/i")
public class itemDetailsController {

	@Resource
	private ItemFacade itemFacade;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showItemDetails(final Model model, @PathVariable int id) {
		ItemDTO item = itemFacade.getItemById(id);
		model.addAttribute("item", item);
		return "detail-view";
	}

}
