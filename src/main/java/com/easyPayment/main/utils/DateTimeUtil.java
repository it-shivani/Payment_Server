package com.easyPayment.main.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	/**
	 * String to Date
	 * 
	 * @param date
	 * @return
	 */
	public static final Date strToDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date rDate = new Date();
		try {
			rDate = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rDate;
	}

	/**
	 * Date to String
	 * 
	 * @param date
	 * @return
	 * @return
	 */
	public static final String dateToStr(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rDate = df.format(date);
		return rDate;
	}

	/**
	 * format Date
	 * 
	 * @param date
	 */
	public static final Date dateFormatUtil(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rDate = df.format(date);
		try {
			date = df.parse(rDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * get now
	 * @return
	 */
	public static final Date now(){
		Date date = new Date();
		dateFormatUtil( date);
		return date;
	}
	
	/**
	 * calculate time in milliseconds from now to date
	 * @param date
	 * @return
	 */
	public static final int calculateTime(Date date){
		Date now = new Date();
		int ss = (int) (Long.parseLong(date.toString())- Long.parseLong(now.toString()));
		return ss;	
	}

}
