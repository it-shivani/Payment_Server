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

import com.easyPayment.main.domains.Lottery;
import com.easyPayment.main.services.LotteryService;
import com.easyPayment.main.utils.DateTimeUtil;
import com.easyPayment.main.utils.ReturnObject;
import com.easyPayment.main.utils.Status;

@RestController
@RequestMapping("lottery")
public class LotteryREST {

	@Autowired
	LotteryService lotteryservice;

	/**
	 * create new lottery
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject createLottery(HttpServletRequest request) {
		Lottery lottery = new Lottery();
		lottery.setBetAmount(Double.parseDouble(request.getParameter("betAmount")));
		lottery.setCreaterId(Integer.parseInt(request.getParameter("creraterId")));
		String datatime = request.getParameter("endDate");
		lottery.setEndDate(DateTimeUtil.strToDate(datatime));
		lottery.setStatus(Status.LOTTERY_OPEN_STR);
		lottery.setTotalAmount(0.0);
		int result = lotteryservice.createLottery(lottery);
		boolean success = false;
		String message = "";
		if (result == Status.LOTTERY_CREATE_SUCCESS) {
			success = true;
			message = "lottery create success";
		} else {
			message = "lottery create failed";
		}
		ReturnObject ro = new ReturnObject(success, message, 0, lottery);
		return ro;
	}

	/**
	 * join a lottery
	 * 
	 * @param lotteryId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public ReturnObject joinLottery(@RequestParam Integer lotteryId, @RequestParam Integer userId) {
		boolean result = lotteryservice.joinLottery(lotteryId, userId);
		String message = "";
		if (result) {
			message = "join success";
		} else {
			message = "join failed";
		}
		ReturnObject ro = new ReturnObject(result, message, 0, null);
		return ro;
	}

	/**
	 * get lottery Detail
	 * 
	 * @param lotteryId
	 * @return
	 */
	@RequestMapping(value = "/{lotteryId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject lotteryDetail(@PathVariable Integer lotteryId) {
		Lottery lottery = lotteryservice.lotteryDetail(lotteryId);
		ReturnObject ro = new ReturnObject(true, "", 1, lottery);
		return ro;
	}

	/**
	 * leave a lottery
	 * @param lotteryId
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public ReturnObject leaveLottery(@RequestParam Integer lotteryId, @RequestParam Integer userId) {
		boolean result = lotteryservice.leaveLottery(lotteryId, userId);
		String message = "";
		if (result) {
			message = "leave success";
		} else {
			message = "leave failed";
		}
		ReturnObject ro = new ReturnObject(result, message, 0, null);
		return ro;
	}

	/**
	 *  get lottery history
	 * @return
	 */
	@RequestMapping(value = "/history/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ReturnObject lotteryHistory(@PathVariable Integer userId) {
		List<Lottery> list = lotteryservice.lotteryHistory(userId);
		ReturnObject ro = new ReturnObject(true, "", list.size(), list);
		return ro;
	}

}
