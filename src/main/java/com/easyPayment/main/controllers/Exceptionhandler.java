package com.easyPayment.main.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.easyPayment.main.utils.ReturnObject;

@ControllerAdvice
public class Exceptionhandler {
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ReturnObject ErrorHandle(Exception e){
		e.printStackTrace();
		ReturnObject ro = new ReturnObject(false, "Internal Error", 0 , null);
		return ro;
		
	}

}
