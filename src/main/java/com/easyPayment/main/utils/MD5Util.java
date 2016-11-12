package com.easyPayment.main.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MD5Util {

	private static SecureRandom random = new SecureRandom();

	/**
	 * Encryption with MD5
	 */
	public static String MD5Encryption(String str) {
		String result = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(str.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        result = sb.toString();
		return result;
	}

	/**
	 * get random salt
	 */
	public static String randomSalt() {
		return new BigInteger(20, random).toString(32);
	}
	
	/**
	 * get random session token
	 */
	public static String nextSession() {
		return new BigInteger(130, random).toString(32);
	}

}
