package com.portal.controller;

import java.util.Locale;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import com.portal.controller.HomeController;

public class HomeControllerTest {
	
	@Test
	public void testViewName() {
		HomeController homeController = new HomeController();
		String viewName = homeController.home(new Locale("en"),
				new ExtendedModelMap() {
				});
		assertEquals("home", viewName);
	}
	
	
}