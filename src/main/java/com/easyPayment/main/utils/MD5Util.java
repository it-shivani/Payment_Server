package com.easyPayment.main.utils;

import java.io.UnsupportedEncodingException;
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
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytesOfMessage = str.getBytes("UTF-8");
			byte[] thedigest = md.digest(bytesOfMessage);
			result = thedigest.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

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
