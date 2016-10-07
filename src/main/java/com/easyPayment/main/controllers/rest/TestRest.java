package com.easyPayment.main.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.HomeService;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("user")
public class TestRest {
	
	@Autowired
	HomeService homeService;

	/**
	 * get user information
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getName(@PathVariable Integer id) {
		User tc = new User();
		tc =homeService.getUser(id);
		return tc;
	}

	/**
	 * post save
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> postName(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		System.out.println("name posted : " + user.getFirstName() + " " + user.getLastName());
		ReturnObject rb = new ReturnObject("true", "post success", null, null);
		return new ResponseEntity<String>(rb.toString(), HttpStatus.OK);
	}

}
