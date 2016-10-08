package com.easyPayment.main.services.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.UserDao;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUserInfo(User user) {
		User result = userDao.getUser(user);
		return result;
	}

	@Override
	public Integer addUser(User user) {
		user.setCreateAt(new Date());
		Integer result = userDao.insertUser(user);
		return result;
	}

	@Override
	public boolean updateUser(User user) {
		user.setUpdateAt(new Date());
		boolean result = userDao.updateUser(user);
		return result;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		User user = new User();
		user.setId(userId);
		user.setDeleteAt(new Date());
		boolean result = userDao.updateUser(user);
		return result;
	}

}
