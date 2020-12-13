package com.spring.kakaologin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map( ) {
	
		return "map";
	}
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info( ) {
	
		return "infoMap";
	}
	
	@RequestMapping(value = "/sample8", method = RequestMethod.GET)
	public String sample8( ) {
	
		return "sample8";
	}
	
	@RequestMapping(value = "/info2", method = RequestMethod.GET)
	public String info2( ) {
	
		return "into";
	}
}
