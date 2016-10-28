package com.easyPayment.main.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.MailService;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("user")
public class UserREST {

	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;

	/**
	 * get user information by user ID-- https://domain.com/user/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getName(@PathVariable Integer id) {
		User tc = new User();
		tc.setId(id);
		tc = userService.getUserInfo(tc, false);
		ReturnObject ro ;
		if(tc == null){
			ro = new ReturnObject(false, "user doesn't exist", 1, null);
		}else{
			ro = new ReturnObject(true, "", 1, tc);
		}
		return ro;
	}
	
	/**
	 * get user information by user email-- https://domain.com/user/byEmail/{email}
	 */
	@RequestMapping(value = "/byEmail/{email}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getUserByEmail(@PathVariable String email) {
		User tc = new User();
		tc.setEmail(email);
		tc = userService.getUserInfo(tc, false);
		ReturnObject ro ;
		if(tc == null){
			ro = new ReturnObject(false, "user doesn't exist", 1, null);
		}else{
			ro = new ReturnObject(true, "", 1, tc);
		}
		return ro;
	}

	/**
	 *  user register-- https://domain.com/user/
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject saveUser(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, 
			@RequestParam(value = "email") String email,
			@RequestParam(value = "phone") String phone, 
			@RequestParam(value = "password") String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		boolean success = false;
		String message = "Email address exist";
		if (!user.check()) {
			message = user.getMessage();
			ReturnObject rb = new ReturnObject(success, message, 0, user);
			return rb;
		} else {
			Integer id = userService.addUser(user);
			if (id == null) {
				message = "internal error";
			} else if (id > 0) {
				success = true;
				message = "save success";
			}
			user.setId(id);
			ReturnObject rb = new ReturnObject(success, message, 0, user);
			return rb;
		}
	}

	/**
	 * login https://domain.com/user/login/
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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

	/**
	 * add a new relation https://domain.com/user/relations
	 */
	@RequestMapping(value = "/relations", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject newRelation(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "friendId") String friendId, 
			@RequestParam(value = "type") String type) {
		boolean result = userService.newRelation(Integer.parseInt(userId), Integer.parseInt(friendId), type);
		ReturnObject rb = new ReturnObject(result, "", 0, null);
		return rb;
	}
	
	/**
	 * delete a relationship https://domain.com/user/relations
	 */
	@RequestMapping(value = "/relations", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnObject deleteRelation(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "friendId") String friendId){
		boolean result = userService.deleteRelation(Integer.parseInt(userId), Integer.parseInt(friendId));
		ReturnObject rb = new ReturnObject(result, "", 0, null);
		return rb;
	}
	
	/**
	 * get relations list https://domain.com/user/relations/{id}
	 */
	@RequestMapping(value = "/relations/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getRelations(@PathVariable Integer id){
		List<User> friends = userService.getRelationList(id);
		ReturnObject rb = new ReturnObject(true, "", 0, friends);
		return rb;
	}
	

}
