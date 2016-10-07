package com.easyPayment.main.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyPayment.main.daos.UserDao;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao ;

	@Override
	public User getUserInfo(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
