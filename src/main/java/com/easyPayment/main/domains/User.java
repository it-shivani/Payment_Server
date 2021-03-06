package com.easyPayment.main.domains;

import java.io.Serializable;
import java.util.Date;

import com.easyPayment.main.utils.DateTimeUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String salt ;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createAt;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateAt;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date deleteAt;
	
	private String message;
	public boolean check(){
		if(firstName == null){
			message = "first name is needed";
			return false;
		}
		if(lastName == null){
			message = "last name is needed";
			return false;
		}
		if(email == null){
			message = "email is needed";
			return false;
		}	
		return true;
	}
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public Date getDeleteAt() {
		return deleteAt;
	}
	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}
	
	

}
