package com.reimburse.rms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimburse.rms.dao.UserDao;
import com.reimburse.rms.entity.RequestEntity;
import com.reimburse.rms.entity.UserEntity;
import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.pojo.RequestPojo;
import com.reimburse.rms.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public UserServiceImpl() {
		
	}

	@Override
	public UserPojo addUser(UserPojo userPojo) {
		//copy the pojo into an entity object
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
						
		//now pass the bookEntity object to spring data jpa to be inserted into the table
		UserEntity returnedUserEntity = userDao.saveAndFlush(userEntity);
		userPojo.setUserId(returnedUserEntity.getUserId());
		return userPojo;
	}

	@Override
	public UserPojo updateUser(UserPojo userPojo) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userPojo, userEntity);
		
		UserEntity returnedUserEntity = userDao.save(userEntity);
		
		return userPojo;
	}

	@Override
	public boolean deleteUser(int userId) {
		userDao.deleteById(userId);
		return true;
	}

	@Override
	public List<UserPojo> getAllUsers() {
		List<UserEntity> allUsersEntity = userDao.findAll();
		//now we have to copy each book entity object in the collection to a 
		//collection of book pojos
		//create an empty collection of book pojos
		List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();
		for(UserEntity fetchedUserEntity: allUsersEntity) {
			UserPojo returnUserPojo = new UserPojo(fetchedUserEntity.getUserId(), fetchedUserEntity.getUserFirstName(), 
					fetchedUserEntity.getUserLastName(), fetchedUserEntity.getUserEmail(), 
					fetchedUserEntity.getUserPassword(), fetchedUserEntity.getUserRole());
			allUsersPojo.add(returnUserPojo);
		}
		return allUsersPojo;
	}

	@Override
	public UserPojo getAUser(int userId) {
		Optional<UserEntity> userEntityOpt = userDao.findById(userId);
		UserPojo userPojo = null;
		if(userEntityOpt.isPresent()) {
			//take out the entity object which is wrapped into the optional object
			UserEntity fetchedUserEntity = userEntityOpt.get();
			//copy the entity into the pojo
			userPojo = new UserPojo(fetchedUserEntity.getUserId(), fetchedUserEntity.getUserFirstName(), 
					fetchedUserEntity.getUserLastName(), fetchedUserEntity.getUserEmail(), 
					fetchedUserEntity.getUserPassword(), fetchedUserEntity.getUserRole());
			//bookPojo = new BookPojo();
			//BeanUtils.copyProperties(fetchedBookEntity, bookPojo); //nested copying will not take place
		}
		return userPojo;
	}
	
	@Override
	public UserPojo getUserByEmailAndPassword(UserPojo userPojo) {
		Optional<UserEntity> userEntityOpt = userDao.findByUserEmailAndUserPassword(userPojo.getUserEmail(), userPojo.getUserPassword());
		userPojo = null;
		if(userEntityOpt.isPresent()) {
			//take out the entity object which is wrapped into the optional object
			UserEntity fetchedUserEntity = userEntityOpt.get();
			//copy the entity into the pojo
			userPojo = new UserPojo(fetchedUserEntity.getUserId(), fetchedUserEntity.getUserFirstName(), 
					fetchedUserEntity.getUserLastName(), fetchedUserEntity.getUserEmail(), 
					fetchedUserEntity.getUserPassword(), fetchedUserEntity.getUserRole());
			//bookPojo = new BookPojo();
			//BeanUtils.copyProperties(fetchedBookEntity, bookPojo); //nested copying will not take place
		}
		return userPojo;
	}

}
