package com.easyPayment.main.controllers.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.EasyPayAccount;
import com.easyPayment.main.services.EasyPayAcctService;
import com.easyPayment.main.utils.ReturnObject;

@RestController
@RequestMapping("easyPayAccount")
public class UserEasyPayAccountREST {

	@Autowired
	EasyPayAcctService easyPayAcctService;

	/**
	 * Get User EasyPay Account Detail
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getAccountDetail(@PathVariable Integer userId) {
		EasyPayAccount epa = easyPayAcctService.getAccount(userId);
		ReturnObject ro = new ReturnObject(true, "", 1, epa);
		return ro;
	}

	/**
	 * Modify User EasyPay Account (not in use)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject modifyAccountDetail(HttpServletRequest request) {
		ReturnObject ro = new ReturnObject(true, "", 0, "");
		return ro;
	}
}
