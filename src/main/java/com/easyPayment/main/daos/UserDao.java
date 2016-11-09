package com.easyPayment.main.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.User;

@Repository
public class UserDao extends BaseDao {

	/**
	 * get user Info by user id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(User user, boolean needPassword) {
		// query for object
		User result = getSqlSession().selectOne("com.easyPayment.user.getUser", user);
		if(result == null){
			return null;
		}
		if(!needPassword){
			result.setSalt("");
			result.setPassword("");
		}
		return result;
	}

	/**
	 * update an user
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		Integer result = getSqlSession().update("com.easyPayment.user.updateUser", user);
		if (result != null && result > 0) {
			return true;
		}

		return false;
	}

	/**
	 * insert an user
	 * 
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user) {
		Integer result = getSqlSession().insert("com.easyPayment.user.insertUser", user);
		return result;
	}

	/**
	 * get user list by condition
	 * 
	 * @param condition
	 * @return
	 */
	public List<User> getUserList(List<Integer> condition) {
		List<User> users = getSqlSession().selectList("com.easyPayment.user.getUserList", condition);
		return users;
	}

	/**
	 * insert a new user relations
	 * 
	 * @param condition
	 * @return
	 */
	public boolean newUserRelation(Integer user1 , Integer user2, String relationType) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("user_1", user1);
		condition.put("user_2", user2);
		condition.put("relationType", relationType);
		Integer result = getSqlSession().insert("com.easyPayment.user.newUserRelation", condition);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * get user relation list
	 * 
	 * @param userID
	 * @return
	 */
	public List<Integer> getRelationList(Integer userID) {
		List<Integer> result ;
		try{
			result = getSqlSession().selectList("com.easyPayment.user.getRelations", userID);
		}catch(Exception e){
			return null;
		}
		return result;
	}

	/**
	 * delete relation
	 * 
	 * @param user1
	 *            user
	 * @param user2
	 *            friend
	 * @return
	 */
	public boolean deleteRelation(Integer user1, Integer user2) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("user_1", user1);
		condition.put("user_2", user2);
		Integer result = getSqlSession().delete("com.easyPayment.user.deleteRelation", condition);
		if (result > 0) {
			return true;
		}
		return false;
	}

}
