package com.crud.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.crud.dtos.ItemDTO;
import com.crud.facades.ItemFacade;
import com.crud.utils.Constants;

/**
 * 
 * @author Mohamed
 *
 */
@Controller
@RequestMapping(value = "/item/")
public class itemDetailsController {

	@Resource
	private ItemFacade itemFacade;

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String showItemDetails(final Model model, @PathVariable int id) {
		// TODO handling errors
		ItemDTO item = itemFacade.getItemById(id);
		model.addAttribute("item", item);
		model.addAttribute("title", "Edit Item");
		return "detail-view";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public RedirectView updateItemDetails(final RedirectAttributes redirectModel,
			@ModelAttribute("item") ItemDTO item) {
		// TODO handling errors
		boolean updated = itemFacade.AddOrUpdateItem(item);
		redirectModel.addFlashAttribute("updated", updated);
		RedirectView redirectView = new RedirectView();
		String redirectUrl = Constants.Controllers.APPLICATION_ROOT;
		if (updated) {
			redirectUrl +="list";
		} else {
			redirectUrl += "item/edit/" + item.getId();
		}
		redirectView.setUrl(redirectUrl);
		return redirectView;
	}

}
