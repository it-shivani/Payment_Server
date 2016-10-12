package com.easyPayment.main.utils;

/**
 * return object 
 * @author zhao_zl_
 *
 */
public class ReturnObject {
	private boolean success;
	private String info;
	private int count;
	private Object result;
	
	
	
	public ReturnObject(boolean success, String info, int count, Object result) {
		super();
		this.success = success;
		this.info = info;
		this.count = count;
		this.result = result;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}

	
}
