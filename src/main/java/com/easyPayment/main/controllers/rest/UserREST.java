package com.easyPayment.main.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("users")
public class UserREST {

	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;

	/**
	 * Checked
	 * get user information by user ID-- https://domain.com/users/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getName(@PathVariable Integer id) {
		if(id == null){
			return new ReturnObject(true, "", 1,"");
		}
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
	 * Checked
	 * search user information -- https://domain.com/users?email=ee@eew.com&name=www
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject searchUser(@PathVariable Integer id) {
		if(id == null){
			return new ReturnObject(true, "", 0,"");
		}
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
	 *  user register (add)-- https://domain.com/users/
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject saveUser(HttpServletRequest request) {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
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
	 * add a new relation (add a new friend) https://domain.com/users/{userId}/friends/{friendId}
	 */
	@RequestMapping(value = "/{userId}/friends/{friendId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject newRelation(@PathVariable String userId,
			@PathVariable String friendId) {
		boolean result = userService.newRelation(Integer.parseInt(userId), Integer.parseInt(friendId), "");
		ReturnObject rb = new ReturnObject(result, "", 0, null);
		return rb;
	}
	
	/**
	 * delete a relationship https://domain.com/users/friends
	 */
	@RequestMapping(value = "/friends", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnObject deleteRelation(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "friendId") String friendId){
		boolean result = userService.deleteRelation(Integer.parseInt(userId), Integer.parseInt(friendId));
		ReturnObject rb = new ReturnObject(result, "", 0, null);
		return rb;
	}
	
	/**
	 * get relations list https://domain.com/users/{userId}/friendList
	 */
	@RequestMapping(value = "/{userId}/friendList", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getRelations(@PathVariable Integer userId){
		List<User> friends = userService.getRelationList(userId);
		ReturnObject rb = new ReturnObject(true, "", friends.size(), friends);
		return rb;
	}
	

}
