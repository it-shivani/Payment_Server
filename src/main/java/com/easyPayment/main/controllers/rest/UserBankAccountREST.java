package com.easyPayment.main.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.*;
import com.easyPayment.main.services.*;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("userbankaccount")
public class UserBankAccountREST {
	
	@Autowired
	UserBankAccountService userBankAccountService;

	/**
	 * get user bank account information by userbankaccount ID-- https://domain.com/userbankaccount/{id}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getName(@PathVariable Integer id,User user) {
		UserBankAccount tc = new UserBankAccount();
		tc = userBankAccountService.getUserBankAccountInfo(tc, user);
		ReturnObject ro = new ReturnObject(true, "", 1, tc);
		return ro;
	}

	/**
	 * add a new user bank account-- https://domain.com/user/
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject saveUser(@RequestParam(value = "balance") double balance,
			@RequestParam(value = "user") User user, 
			@RequestParam(value = "accountNumber") long accountNumber,
			@RequestParam(value = "bankName") String bankName, 
			@RequestParam(value = "swiftCode") int swiftCode,
			@RequestParam(value = "country") String country) {
		UserBankAccount uba = new UserBankAccount();
		uba.setAccountNumber(accountNumber);
		uba.setBalance(balance);
		uba.setBankName(bankName);
		uba.setCountry(country);
		uba.setSwiftCode(swiftCode);
		uba.setUser(user);
        
		boolean success = false;
		String message = "Account Created";
//		if (!user.check()) {
//			message = user.getMessage();
//			ReturnObject rb = new ReturnObject(success, message, 0, user);
//			return rb;
//		} else {
			Integer id = userBankAccountService.addUserBankAccount(uba, user);
			if (id == null) {
				message = "internal error";
			} else if (id > 0) {
				success = true;
				message = "save success";
			}
			uba.setAccountId(id);
			ReturnObject rb = new ReturnObject(success, message, 0, uba);
			return rb;
		}
//	}
}
