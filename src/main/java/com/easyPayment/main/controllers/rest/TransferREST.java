package com.easyPayment.main.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.domains.UserBankAccount;
import com.easyPayment.main.services.TransferService;
import com.easyPayment.main.utils.ReturnObject;
import com.easyPayment.main.utils.Status;

@RestController
@RequestMapping("transfer")
public class TransferREST {

	@Autowired
	TransferService transferService;

	/**
	 * Transfer money to other user
	 * 
	 * @param user1
	 * @param user2
	 * @param amount
	 * @return
	 */
	@RequestMapping(value = "/toUser", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferToUser(@RequestParam Integer user1, @RequestParam Integer user2,
			@RequestParam double amount) {
		Transaction trans = new Transaction();
		trans.setUserId(user1);
		trans.setToAcct(user2);
		trans.setAmount(amount);
		trans.setDescription("Transfer to others");
		int result = transferService.makeTransferToUser(trans);
		ReturnObject ro = null;
		if (result == Status.TRANSFER_SUCCESS) {
			ro = new ReturnObject(true, "", 0, null);
		} else {
			ro = new ReturnObject(false, " Transfer Failed", 0, null);
		}
		return ro;
	}

	/**
	 * transfer money to user bank account
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 */
	@RequestMapping(value = "/toBank", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferToBank(@RequestParam Integer userId, @RequestParam double amount,
			@RequestParam Integer bankAccountId) {
		UserBankAccount uba = new UserBankAccount();
		uba.setId(bankAccountId);
		int result = transferService.makeTransferToBank(uba, amount);
		ReturnObject ro = null;
		if (result == Status.TRANSFER_SUCCESS) {
			ro = new ReturnObject(true, "", 0, null);
		} else {
			ro = new ReturnObject(false, " Transfer Failed", 0, null);
		}
		return ro;
	}

	/**
	 * transfer money from user bank account to user easy-pay account
	 * 
	 * @param amount
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/fromBank", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject makeTransferFromBank(@RequestParam double amount, @RequestParam Integer userId,
			@RequestParam Integer bankAccountId) {

		UserBankAccount uba = new UserBankAccount();
		uba.setId(bankAccountId);
		int result = transferService.makeTransferFromBank(uba, amount);
		ReturnObject ro = null;
		if (result == Status.TRANSFER_SUCCESS) {
			ro = new ReturnObject(true, "", 0, null);
		} else {
			ro = new ReturnObject(false, " Transfer Failed", 0, null);
		}
		return ro;
	}

	@RequestMapping(value = "/{transerId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getTransferDetail(@PathVariable Integer transerId) {
		return null;
	}

	/**
	 * get user transaction list with detail
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject getTransferList(@PathVariable Integer userId) {
		Transaction trans = new Transaction();
		trans.setUserId(userId);
		List<Transaction> list = transferService.transferList(trans);
		ReturnObject ro = new ReturnObject(true, " ", list.size(), list);
		return ro;
	}

}
