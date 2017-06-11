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
@RequestMapping(value = "/detail/i")
public class itemDetailsController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showItemDetails(final Model model) {
		// TODO later
		return "detail-view";
	}

}
