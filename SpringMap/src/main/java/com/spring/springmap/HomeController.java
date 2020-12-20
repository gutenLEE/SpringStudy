package com.spring.springmap;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {

		
		return "index";
	}

	
}
