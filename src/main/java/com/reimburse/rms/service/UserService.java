package com.reimburse.rms.service;

import java.util.List;

import com.reimburse.rms.pojo.UserPojo;

public interface UserService {
	UserPojo addUser(UserPojo userPojo);
	
	UserPojo updateUser(UserPojo userPojo);
	
	boolean deleteUser(int userId);
	
	List<UserPojo> getAllUsers();
	
	UserPojo getAUser(int userId);
}
