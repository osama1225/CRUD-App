package com.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Mohamed
 *
 */
@Controller
@RequestMapping(value="/list")
public class itemsListController{
	
	@RequestMapping(method = RequestMethod.GET)
	public String showItems(final Model model) {
		// TODO to be implemented later
		return "list-view";
	}

	
}
