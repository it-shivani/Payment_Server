package com.easyPayment.main.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.Transaction;

@Repository
public class TransactionDao extends BaseDao {

	/**
	 * add a new transaction
	 * 
	 * @param trans
	 * @return
	 */
	public Integer addNewTransaction(Transaction trans) {
		Integer result = getSqlSession().insert("com.easyPayment.transaction.newTransaction", trans);
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
