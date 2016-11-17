package com.easyPayment.main.timer;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easyPayment.main.services.LotteryService;

public class LotteryTimer extends TimerTask {

	Integer lotteryId;

	public LotteryTimer(Integer lotteryId,LotteryService lotteryservice) {
		this.lotteryId = lotteryId;
		this.lotteryservice = lotteryservice;
	}


	LotteryService lotteryservice;

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);


	@Override
	public void run() {
		lotteryservice.lotteryEnd(lotteryId);
		log.info(" process lottery task");
	}

}
