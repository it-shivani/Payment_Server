package com.easyPayment.main.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.UserDao;
import com.easyPayment.main.domains.EasyPayAccount;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.services.EasyPayAcctService;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.DateTimeUtil;
import com.easyPayment.main.utils.MD5Util;
import com.easyPayment.main.utils.Status;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	EasyPayAcctService easyPayAcctService;

	@Override
	public User getUserInfo(User user, boolean needPassword) {
		User result = userDao.getUser(user, needPassword);
		return result;
	}

	@Override
	public List<User> getUserList(User user) {
		checkNull(user);
		List<User> result = userDao.getUserList(user);
		return result;
	}

	@Override
	public Integer addUser(User user) {
		// check user
		User temp = new User();
		temp.setEmail(user.getEmail());
		if (checkUser(temp) != Status.CHECK_USER_DOESNT_EXIST) {
			return 0;
		}
		user.setCreateAt(DateTimeUtil.now());
		String password = user.getPassword();
		// 4 digital salt
		String salt = MD5Util.randomSalt();
		password = MD5Util.MD5Encryption(password + salt);
		user.setSalt(salt);
		user.setPassword(password);
		Integer result = userDao.insertUser(user);
		if (result > 0) {
			// add an easy Pay Account
			EasyPayAccount epa = new EasyPayAccount();
			epa.setBalance(0.0d);
			epa.setUserId(result);
			epa.setAcctNo("");
			easyPayAcctService.addNewAcct(epa);
		}
		return result;
	}

	@Override
	public boolean updateUser(User user) {
		user.setUpdateAt(DateTimeUtil.now());
		checkNull(user);
		// if change password
		if (user.getPassword() != null) {
			String salt = MD5Util.randomSalt();
			String password = MD5Util.MD5Encryption(user.getPassword() + salt);
			user.setSalt(salt);
			user.setPassword(password);
		}
		boolean result = userDao.updateUser(user);
		return result;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		User user = new User();
		user.setId(userId);
		user.setDeleteAt(DateTimeUtil.now());
		boolean result = userDao.updateUser(user);
		return result;
	}

	@Override
	public boolean newRelation(Integer user1, Integer user2, String relationType) {
		List<Integer> relations = userDao.getRelationList(user1);
		// check user2 if already is a friend
		if (relations != null && relations.contains(user2)) {
			return true;
		}
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
	public int checkUser(User user) {
		String password = user.getPassword();
		user.setPassword(null);
		User result = getUserInfo(user, true);
		if (result == null) {
			return Status.CHECK_USER_DOESNT_EXIST;
		} else {
			if (password != null && !password.equals("")) {
				String temp = MD5Util.MD5Encryption(password + result.getSalt());
				if (temp.equals(result.getPassword())) {
					return Status.CHECK_SUCCESS;
				}
				return Status.CHECK_WRONG_PASSWORD;
			} else {
				return Status.CHECK_SUCCESS;
			}
		}
	}

	public void checkNull(User user) {
		if (user.getFirstName() != null && user.getFirstName().equals("")) {
			user.setFirstName(null);
		}
		if (user.getLastName() != null && user.getLastName().equals("")) {
			user.setLastName(null);
		}
		if (user.getEmail() != null && user.getEmail().equals("")) {
			user.setEmail(null);
		}
		if (user.getPhone() != null && user.getPhone().equals("")) {
			user.setPhone(null);
		}
		if (user.getPassword() != null && user.getPassword().equals("")) {
			user.setPassword(null);
		}
		if (user.getId() != null && user.getId().equals("")) {
			user.setId(null);
		}
	}

	@Override
	public Map<String, Object> loginCheck(User user) {
		// userStatue
		int userStatue = 3;
		String password = user.getPassword();
		user.setPassword(null);
		User result = getUserInfo(user, true);
		if (result == null) {
			userStatue = Status.CHECK_USER_DOESNT_EXIST;
		} else {
			if (password != null && !password.equals("")) {
				String temp = MD5Util.MD5Encryption(password + result.getSalt());
				if (temp.equals(result.getPassword())) {
					userStatue = Status.CHECK_SUCCESS;
				} else {
					userStatue = Status.CHECK_WRONG_PASSWORD;
				}
			}
		}

		int check = userStatue;
		boolean cresult = false;
		String message = "";
		switch (check) {
		case Status.CHECK_SUCCESS:
			cresult = true;
			message = "login success";
			break;
		case Status.CHECK_WRONG_PASSWORD:
			cresult = false;
			result = null;
			message = "wrong password";
			break;
		case Status.CHECK_USER_DOESNT_EXIST:
			cresult = false;
			result = null;
			message = "user doesn't exist";
			break;
		}
		result.setPassword(null);
		result.setSalt(null);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", result);
		map.put("result", cresult);
		map.put("message", message);

		return map;
	}

}
