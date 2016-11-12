package com.easyPayment.main.services;

import java.util.List;

import com.easyPayment.main.domains.User;

public interface UserService {

	/**
	 * find user through some user's information
	 * 
	 * @param user
	 * @param needPassword
	 * @return
	 */
	public User getUserInfo(User user, boolean needPassword);
	
	/**
	 * get user list 
	 * @param user
	 * @return
	 */
	public List<User> getUserList(User user);
	
	/**
	 * check user
	 * @param user
	 * @return
	 */
	public int checkUser(User user);

	/**
	 * add a new user
	 * 
	 * @param user
	 * @return
	 */
	public Integer addUser(User user);

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

	/**
	 * add a new user relation
	 * 
	 * @param user1
	 * @param user2
	 * @param type
	 * @return
	 */
	public boolean newRelation(Integer user1, Integer user2, String type);

	/**
	 * get user friend list
	 * 
	 * @param userID
	 * @return
	 */
	public List<User> getRelationList(Integer userID);

	/**
	 * delete a user relation
	 * 
	 * @param user1
	 * @param user2
	 * @return
	 */
	public boolean deleteRelation(Integer user1, Integer user2);

}
