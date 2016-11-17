package com.easyPayment.main.utils;

import java.util.Random;

public class RandomUtil {
	
	/**
	 * get random number from 0 to max-1
	 * @param max
	 * @return
	 */
	public static int randomNumber(int max){
		if(max == 0){
			return 0 ;
		}
		Random rand = new Random();
		int  n = rand.nextInt(max);
		return n ;
	}

}
