package com.easyPayment.main.services;

import com.easyPayment.main.domains.User;

public interface UserService {

	/**
	 * find user through some user's information
	 * 
	 * @param user
	 * @return
	 */
	public User getUserInfo(User user);

	/**
	 * add a new user
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);

	/**
	 * update a user
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

	/**
	 * delete user through user id
	 * 
	 * @param userId
	 * @return
	 */
	public boolean deleteUser(Integer userId);

}
