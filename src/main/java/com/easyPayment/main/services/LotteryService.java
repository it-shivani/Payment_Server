package com.easyPayment.main.services;

import java.util.List;

import com.easyPayment.main.domains.Lottery;

public interface LotteryService {

	/**
	 * create a new lottery
	 * 
	 * @param lottery
	 * @return
	 */
	public int createLottery(Lottery lottery);

	/**
	 * join a lottery
	 * 
	 * @param lotteryId
	 * @param userId
	 * @return
	 */
	public boolean joinLottery(Integer lotteryId, Integer userId);

	/**
	 * leave a lottery
	 * 
	 * @param lotteryId
	 * @param userId
	 * @return
	 */
	public boolean leaveLottery(Integer lotteryId, Integer userId);

	/**
	 * get a lottery detail
	 * 
	 * @param lotteryId
	 * @return
	 */
	public Lottery lotteryDetail(Integer lotteryId);

	/**
	 * get one user's lottery history
	 * 
	 * @param userId
	 * @return
	 */
	public List<Lottery> lotteryHistory(Integer userId);
	
	/**
	 * end a lottery
	 * @param lotteryId
	 * @return
	 */
	public boolean lotteryEnd(Integer lotteryId);

}
