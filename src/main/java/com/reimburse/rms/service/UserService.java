package com.reimburse.rms.service;

import java.util.List;

import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.exception.UserNotFoundException;
import com.reimburse.rms.pojo.UserPojo;

public interface UserService {
	UserPojo addUser(UserPojo userPojo) throws ApplicationException;
	
	UserPojo updateUser(UserPojo userPojo) throws ApplicationException;
	
	boolean deleteUser(int userId) throws ApplicationException;
	
	List<UserPojo> getAllUsers() throws ApplicationException;
	
	UserPojo getAUser(int userId) throws ApplicationException;

	UserPojo getUserByEmailAndPassword(UserPojo userPojo) throws ApplicationException, UserNotFoundException;
}
