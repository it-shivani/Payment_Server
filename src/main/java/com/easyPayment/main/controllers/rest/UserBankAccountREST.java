package com.easyPayment.main.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.UserBankAccount;
import com.easyPayment.main.services.UserBankAccountService;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("userBankAccount")
public class UserBankAccountREST {

	@Autowired
	UserBankAccountService userBankAccountService;

	/**
	 * get user bank account list by user id ID--
	 * https://domain.com/userbankaccount/{userid}
	 */
	@RequestMapping(value = "/{userid}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getUserBankAccounts(@PathVariable Integer userid) {
		UserBankAccount uba = new UserBankAccount();
		// test
		uba.setId(userid);
		List<UserBankAccount> ubals = userBankAccountService.getUserBankAccountList(uba);
		ReturnObject ro;
		if (ubals.size() <= 0) {
			ro = new ReturnObject(false, "no user bank account found", 0, null);
		} else {
			ro = new ReturnObject(true, "", ubals.size(), ubals);
		}
		return ro;
	}

	/**
	 * add a new user bank account-- https://domain.com/user/
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject saveUserBankAccount(@RequestParam(value = "userId") Integer userId,
			@RequestParam(value = "accountNumber") String accountNumber,
			@RequestParam(value = "bankName") String bankName, @RequestParam(value = "swiftCode") String swiftCode,
			@RequestParam(value = "country") String country) {
		UserBankAccount uba = new UserBankAccount();
		uba.setAccountNumber(accountNumber);
		uba.setBankName(bankName);
		uba.setCountry(country);
		uba.setSwiftCode(swiftCode);
		uba.setUserId(userId);

		boolean success = false;
		String message = "Account Created";

		Integer id = userBankAccountService.addUserBankAccount(uba);
		if (id == null) {
			message = "internal error";
		} else if (id > 0) {
			success = true;
			message = "save success";
			uba.setId(id);
		}
		ReturnObject rb = new ReturnObject(success, message, 0, null);
		return rb;
	}

	/**
	 * delete User Bank Account
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnObject deleteUserBankAccount(@RequestParam(value = "accountId") Integer accountId) {
		boolean result = userBankAccountService.deleteUserBankAccount(accountId);
		ReturnObject ro = new ReturnObject(result, "", 0, null);
		return ro;
	}

}
