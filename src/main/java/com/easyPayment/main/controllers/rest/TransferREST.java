package com.easyPayment.main.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("transfer")
public class TransferREST {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransfer(@RequestParam(value = "user1") String user1, 
			@RequestParam(value = "user2") String user2,
			@RequestParam(value = "token") String token){
		
		return null;
	}

}
