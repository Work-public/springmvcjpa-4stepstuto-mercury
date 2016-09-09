package com.companyname.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.springapp.service.PriceIncrease;
import com.companyname.springapp.service.ProductManager;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Controller
@RequestMapping(value = "/priceincrease.htm")
public class PriceIncreaseFormController {

	@Autowired
	private ProductManager productManager;

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result) {
		if (result.hasErrors()) {
			return "priceincrease";
		}

		int increase = priceIncrease.getPercentage();
		log.info("Increasing prices by " + increase + "%.");

		productManager.increasePrice(increase);

		return "redirect:/hello.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected PriceIncrease formBackingObject(HttpServletRequest request) throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(15);
		return priceIncrease;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

}
