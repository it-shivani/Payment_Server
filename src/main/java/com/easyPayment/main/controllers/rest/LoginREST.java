package com.easyPayment.main.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("login")
public class LoginREST {
	
	@Autowired
	UserService userService;
	
	/**
	 * login https://domain.com/login/
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject login(@RequestParam(value = "email") String email, 
			@RequestParam(value = "phone") String phone,
			@RequestParam(value = "password") String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		boolean check = userService.checkUser(user);
		ReturnObject rb = new ReturnObject(check, "", 0, null);
		return rb;
	}

}
