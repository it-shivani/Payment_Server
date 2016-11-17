package com.easyPayment.main.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.Lottery;

@Repository
public class LotteryDao extends BaseDao {

	/**
	 * create a new lottery
	 * 
	 * @param lottery
	 * @return
	 */
	public Integer createLottery(Lottery lottery) {
		Integer result = getSqlSession().insert("com.easyPayment.lottery.newLottery", lottery);
		if (result != null && result > 0) {
			return lottery.getId();
		}
		return result;
	}

	/**
	 * join a lottery
	 * 
	 * @param userId
	 * @param loteryId
	 * @param amount
	 * @return
	 */
	public boolean joinLottery(Integer userId, Integer loteryId, double amount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("lotteryId", loteryId);
		map.put("amount", amount);
		Integer result = getSqlSession().insert("com.easyPayment.lottery.joinLottey", map);
		if (result != null && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * get Lottery Detail
	 * 
	 * @param lottery
	 * @return
	 */
	public Lottery getLotteryDetail(Lottery lottery) {
		Lottery result = getSqlSession().selectOne("com.easyPayment.lottery.getLottery", lottery);
		return result;
	}

	/**
	 * leave Lottery
	 * 
	 * @param userId
	 * @param loteryId
	 * @return
	 */
	public boolean leaveLottery(Integer userId, Integer loteryId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("loteryId", loteryId);
		Integer result = getSqlSession().delete("com.easyPayment.lottery.leaveLottery", map);
		if (result != null && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * get Lottery History
	 * 
	 * @param userId
	 * @return
	 */
	public List<Lottery> getLotteryHistory(Integer userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<Lottery> result = getSqlSession().selectList("com.easyPayment.lottery.getLotteryHistory", map);
		return result;
	}

	/**
	 * update lottery
	 * 
	 * @param lottery
	 * @return
	 */
	public boolean updateLottery(Lottery lottery) {
		Integer result = getSqlSession().update("com.easyPayment.lottery.updateLottery", lottery);
		if (result > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * get Lottery Users
	 * @param lotteryId
	 * @return
	 */
	public List<Integer> getLotteryUsers(Integer lotteryId){
		List<Integer> result = getSqlSession().selectList("com.easyPayment.lottery.getUsers", lotteryId);
		return result ;
	}

}
