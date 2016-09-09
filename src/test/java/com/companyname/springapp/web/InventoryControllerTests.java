package com.companyname.springapp.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.companyname.springapp.service.SimpleProductManager;

import lombok.val;

public class InventoryControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {
		val controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		val modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		val modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}
}
