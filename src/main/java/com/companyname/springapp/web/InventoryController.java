package com.companyname.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.service.ProductManager;

import lombok.Setter;
import lombok.val;
import lombok.extern.apachecommons.CommonsLog;

@Controller
@CommonsLog
public class InventoryController {
	@Autowired
	@Setter
	private ProductManager productManager;

	@RequestMapping(value = "/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String now = (new Date()).toString();
		log.info("Returning hello view with " + now);
		val myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
	}
}
