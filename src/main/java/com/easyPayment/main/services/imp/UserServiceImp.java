package com.easyPayment.main.services.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.UserDao;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.MD5Util;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUserInfo(User user, boolean needPassword) {
		User result = userDao.getUser(user, needPassword);
		return result;
	}

	@Override
	public Integer addUser(User user) {
		//check user
		User temp = new User();
		temp.setEmail(user.getEmail());
		if(checkUser(temp)){
			return 0;
		}
		user.setCreateAt(new Date());
		String password = user.getPassword();
		//4 digital salt
		String salt = MD5Util.randomSalt();
		password = MD5Util.MD5Encryption(password+salt);
		user.setSalt(salt);
		user.setPassword(password);
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

	@Override
	public boolean newRelation(Integer user1, Integer user2, String relationType) {
		boolean result = userDao.newUserRelation(user1, user2, relationType);
		return result;
	}

	@Override
	public List<User> getRelationList(Integer userID) {
		List<Integer> list = userDao.getRelationList(userID);
		List<User> users = new ArrayList<User>();
		for (Integer i : list) {
			User friend = new User();
			friend.setId(i);
			friend = userDao.getUser(friend, false);
			users.add(friend);
		}
		return users;
	}

	@Override
	public boolean deleteRelation(Integer user1, Integer user2) {
		boolean result = userDao.deleteRelation(user1, user2);
		return result;
	}

	@Override
	public boolean checkUser(User user) {
		String password = user.getPassword();
		user.setPassword(null);
		User result = getUserInfo(user, true);
		if (result == null) {
			return false;
		} else {
			if (password != null) {
				String temp = MD5Util.MD5Encryption(password + result.getSalt());
				if (temp.equals(result.getPassword())) {
					return true;
				}
				return false;
			} else {
				return true;
			}
		}
	}

}
