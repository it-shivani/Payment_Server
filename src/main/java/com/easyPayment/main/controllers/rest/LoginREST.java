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
import com.easyPayment.main.utils.Status;

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
			@RequestParam(value = "password") String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		int check = userService.checkUser(user);
		boolean result = false;
		String message = "";
		switch (check) {
		case Status.CHECK_SUCCESS:
			result = true;
			message = "login success";
			break;
		case Status.CHECK_WRONG_PASSWORD:
			result = false;
			message = "wrong password";
			break;
		case Status.CHECK_USER_DOESNT_EXIST:
			result = false;
			message = "user doesn't exist";
			break;
		}
		ReturnObject rb = new ReturnObject(result, message, 0, null);
		return rb;
	}

}
