package com.easyPayment.main.controllers.pages;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.ReturnObject;

/**
 * Handles requests for the application home page.
 */
@CrossOrigin
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService userService;
	
	/**
	 * home page
	 */
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	/**
	 * signin page
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin( Model model) {

		return "signin";
	}
	
	/**
	 * web signin 
	 */
	@RequestMapping(value = "/web/signin", method = RequestMethod.POST)
	public String websignin(@RequestBody User user, Model model) {
		System.out.println(user.getEmail());
		Map<String, Object> map = userService.loginCheck(user);
		boolean result = (boolean) map.get("result");
		String message =  (String) map.get("message");
		User cuser = (User) map.get("user");
		ReturnObject rb = new ReturnObject(result, message, 0, cuser);
		return "signin";
	}
	
	/**
	 * register page
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register( Model model) {

		return "register";
	}
	
	/**
	 * appDownload page
	 */
	@RequestMapping(value = "/appDownload", method = RequestMethod.GET)
	public String appDownload( Model model) {

		return "appDownload";
	}
	
	
	
	/**
	 * TEST Page 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("Welcome test! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
}
