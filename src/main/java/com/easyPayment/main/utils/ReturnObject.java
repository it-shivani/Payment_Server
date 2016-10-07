package com.easyPayment.main.utils;

/**
 * return object (json)
 * @author zhao_zl_
 *
 */
public class ReturnObject {
	private String statue;
	private String message;
	private String objKey;
	private String obj;

	/**
	 * 
	 * @param statue
	 *            return status true or false
	 * @param message
	 *            return message , can be null
	 * @param objKey
	 *            return object key name, can be null
	 * @param obj
	 *            return object , can be null
	 */
	public ReturnObject(String statue, String message, String objKey, String obj) {
		this.statue = statue;
		this.message = message == null ? "" : message;
		this.objKey = objKey == null ? "key" : objKey;
		this.obj = obj == null ? "" : obj;
	}

	@Override
	public String toString() {
		return "{\"success\":\"" + statue + "\", \"message\":\"" + message + "\", \"" + objKey + "\":\"" + obj + "\"}";
	}
}
