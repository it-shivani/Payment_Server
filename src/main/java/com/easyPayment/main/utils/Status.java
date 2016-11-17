package com.easyPayment.main.utils;

public class Status {
	
	// transfer money return status
	public static final int TRANSFER_SUCCESS = 0;
	public static final int TRANSFER_FAILED = 1;
	public static final int TRANSFER_BALANCE_NOT_ENOUGH = 2;
	public static final int TRANSFER_USER_DOESNOT_EXISTED = 3;
	
	//tansfer to/from bank
	public static final int INSUFFICIENT_BALANCE = 2;

	//login and check user
	public static final int CHECK_SUCCESS = 0 ;
	public static final int CHECK_WRONG_PASSWORD = 1 ;
	public static final int CHECK_USER_DOESNT_EXIST = 2 ;
	
	//lottery
	public static final int LOTTERY_CREATE_SUCCESS = 0;
	public static final int LOTTERY_CREATE_FAILED = 1;
	
	//lottery status
	public static final int LOTTERY_OPEN = 0;
	public static final int LOTTERY_CLOSE = 1;
	
	public static final String LOTTERY_OPEN_STR="OPEN";
	public static final String LOTTERY_CLOSE_STR="CLOSED";
	
	public static final int LOTTERY_JOIN_SUCCESS = 0;
	public static final int LOTTERY_JOIN_FAILED = 1;
}
