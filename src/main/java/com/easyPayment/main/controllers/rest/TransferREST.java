package com.easyPayment.main.controllers.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("transfer")
public class TransferREST {
	
	
	@RequestMapping(value = "/toUser", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferToUser(@RequestParam(value = "user1") String user1, 
			@RequestParam(value = "user2") String user2,
			@RequestParam(value = "token") String token){
		
		return null;
	}
	
	@RequestMapping(value = "/toBank", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferToBank(@RequestParam(value = "amount") String amount, 
			@RequestParam(value = "token") String token){
		
		return null;
	}
	
	@RequestMapping(value = "/fromBank", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferFromBank(@RequestParam(value = "amount") String amount, 
			@RequestParam(value = "token") String token){
		
		return null;
	}
	
	@RequestMapping(value = "/{transerId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getTransferDetail(@PathVariable Integer transerId){
		return null;
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PATCH)
	@ResponseBody
	public ReturnObject getTransferList(@PathVariable Integer transerId){
		return null;
	}

}
