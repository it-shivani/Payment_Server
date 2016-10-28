package com.easyPayment.main.services;

/**
 * for internal transfer 
 * @author zhao_zl_
 *
 */
public interface InternalTransferService {

	/**
	 * transfer money  at same bank
	 * @return
	 */
	public boolean transferAtSameBank();

	/**
	 * transfer money between different banks
	 * @return
	 */
	public boolean TransferBtnNanks();

}
