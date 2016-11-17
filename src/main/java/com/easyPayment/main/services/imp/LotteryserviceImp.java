package com.easyPayment.main.services.imp;

import java.util.List;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.easyPayment.main.daos.LotteryDao;
import com.easyPayment.main.domains.Lottery;
import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.services.LotteryService;
import com.easyPayment.main.services.TransferService;
import com.easyPayment.main.timer.LotteryTimer;
import com.easyPayment.main.utils.RandomUtil;
import com.easyPayment.main.utils.Status;

@Service
public class LotteryserviceImp implements LotteryService {

	@Autowired
	LotteryDao lotteryDao;

	@Autowired
	TransferService transferService;

	@Override
	public int createLottery(Lottery lottery) {
		// check lottery
		if (!lottery.checkLottery()) {
			return Status.LOTTERY_CREATE_FAILED;
		}
		Integer result = lotteryDao.createLottery(lottery);
		if (result > 0) {
			// join
			//lotteryDao.joinLottery(lottery.getCreaterId(), result, lottery.getBetAmount());
			joinLottery(result, lottery.getCreaterId());
			// put in timer
			LotteryTimer ltimer = new LotteryTimer(result, this);
			Timer timer = new Timer();
			timer.schedule(ltimer, lottery.getEndDate());
			return Status.LOTTERY_CREATE_SUCCESS;
		}
		return Status.LOTTERY_CREATE_FAILED;
	}

	@Override
	public boolean joinLottery(Integer lotteryId, Integer userId) {
		Lottery temp = new Lottery();
		temp.setId(lotteryId);
		// check lottery still open
		Lottery lottery = lotteryDao.getLotteryDetail(temp);
		if (lottery.getStatus().equals(Status.LOTTERY_CLOSE_STR)) {
			return false;
		}
		// join
		boolean result = lotteryDao.joinLottery(userId, lotteryId, lottery.getBetAmount());
		if (result) {
			// change total amount
			temp.setBetAmount(lottery.getBetAmount());
			temp.setTotalAmount(lottery.getTotalAmount() + lottery.getBetAmount());
			lotteryDao.updateLottery(temp);
		}
		return result;
	}

	@Override
	public boolean leaveLottery(Integer lotteryId, Integer userId) {
		Lottery temp = new Lottery();
		temp.setId(lotteryId);
		// check lottery still open
		Lottery lottery = lotteryDao.getLotteryDetail(temp);
		if (lottery.getStatus().equals(Status.LOTTERY_CLOSE_STR)) {
			return false;
		}
		// leave
		boolean result = lotteryDao.leaveLottery(userId, lotteryId);
		if (result) {
			// change total amount
			temp.setTotalAmount(lottery.getTotalAmount() - lottery.getBetAmount());
			lotteryDao.updateLottery(lottery);
		}
		return result;
	}

	@Override
	public Lottery lotteryDetail(Integer lotteryId) {
		Lottery temp = new Lottery();
		temp.setId(lotteryId);
		Lottery lottery = lotteryDao.getLotteryDetail(temp);
		return lottery;
	}

	@Override
	public List<Lottery> lotteryHistory(Integer userId) {
		List<Lottery> list = lotteryDao.getLotteryHistory(userId);
		return list;
	}

	@Override
	public boolean lotteryEnd(Integer lotteryId) {
		Lottery temp = new Lottery();
		temp.setId(lotteryId);
		Lottery lottery = lotteryDao.getLotteryDetail(temp);
		//check if closed
		if(lottery.getStatus().equals(Status.LOTTERY_CLOSE_STR)){
			return true;
		}
		lottery.setStatus(Status.LOTTERY_CLOSE_STR);
		// generate winner
		List<Integer> users = lotteryDao.getLotteryUsers(lotteryId);
		Integer winner = users.get(RandomUtil.randomNumber(users.size()));
		lottery.setWinnerId(winner);
		lotteryDao.updateLottery(lottery);
		// transfer money to winner
		for (Integer user : users) {
			if (user.equals(winner)) {
				continue;
			}
			Transaction trans = new Transaction();
			trans.setUserId(user);
			trans.setToAcct(winner);
			trans.setAmount(lottery.getBetAmount());
			trans.setDescription("Transfer to lottery winner");
			transferService.makeTransferToUser(trans);
		}
		return true;
	}

}
