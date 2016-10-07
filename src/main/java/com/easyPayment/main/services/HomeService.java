package com.easyPayment.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyPayment.main.daos.HomeDao;
import com.easyPayment.main.domains.User;

@Service
public class HomeService {
	
	@Autowired
	HomeDao homeDao;

	/**
	 * Demo for get user name 
	 * @param id
	 * @return
	 */
	public User getUser(Integer id){
		User user = new User();
		user.setId(id);
		user = homeDao.GetUser(user);
		
		return user;
	}
}
