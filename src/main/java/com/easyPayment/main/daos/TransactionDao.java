package com.easyPayment.main.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.utils.DateTimeUtil;

@Repository
public class TransactionDao extends BaseDao {

	/**
	 * add a new transaction
	 * 
	 * @param trans
	 * @return
	 */
	public Integer addNewTransaction(Transaction trans) {
		trans.setPostTime(DateTimeUtil.now());
		Integer result = getSqlSession().insert("com.easyPayment.transaction.newTransaction", trans);
		if (result != null && result > 0) {
			return trans.getId();
		}
		return result;
	}

	/**
	 * get transaction list
	 * 
	 * @param trans
	 * @return
	 */
	public List<Transaction> getTransList(Transaction trans) {
		List<Transaction> resultList = getSqlSession().selectList("com.easyPayment.transaction.getTransactions", trans);
		return resultList;
	}

}
