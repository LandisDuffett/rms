package com.reimburse.rms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.transaction.SystemException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.reimburse.rms.dao.UserDao;
import com.reimburse.rms.entity.UserEntity;
import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.pojo.UserPojo;
import com.reimburse.rms.service.UserService;
import com.reimburse.rms.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserServiceImpl userService;
	
	private UserPojo expectedUserPojo;
	private UserEntity dummyUserEntity;
	
	@BeforeEach
	public void setup() {
		expectedUserPojo = new UserPojo(1, "Joe", "Cool", "jcool@gmail.com", "password", "employee");
		dummyUserEntity = new UserEntity(1, "Joe", "Cool", "jcool@gmail.com", "password", "employee");
	}
	
	/*
	@DisplayName("JUnit test for add user meethod")
	@Test
	public void testAddUser() throws ApplicationException {
		when(userDao.saveAndFlush(dummyUserEntity)).thenReturn(dummyUserEntity);
		
		UserPojo sendUserPojo = new UserPojo(1, "Joe", "Cool", "jcool@gmail.com", "password", "employee");
		UserPojo actualUserPojo = userService.addUser(sendUserPojo);
		
		assertEquals(2, actualUserPojo.getUserId());
	}*/
	
	 // JUnit test for getAllBooks method
    @DisplayName("JUnit test for getAllUsers method")
    @Test
    public void testGetAllUsers() throws ApplicationException {
        when(userDao.findAll()).thenReturn(List.of(dummyUserEntity, dummyUserEntity));
   
        List<UserPojo> actualAllUserPojoList = userService.getAllUsers();

        assertNotNull(actualAllUserPojoList);
        assertEquals(2, actualAllUserPojoList.size());
    }
    
    // JUnit test for getABook method
    @DisplayName("JUnit test for getAUser method")
    @Test
    public void testGetAUser() throws ApplicationException {
    	when(userDao.findById(1)).thenReturn(Optional.of(dummyUserEntity));
    	UserPojo actualUserPojo = userService.getAUser(1);
    	assertEquals(expectedUserPojo, actualUserPojo);
    }
    
    // JUnit test for deleteBook method
    @DisplayName("JUnit test for deleteUser method")
    @Test
    public void testDeleteUser() throws ApplicationException {
    	doNothing().when(userDao).deleteById(1);
    	userService.deleteUser(1);
    	verify(userDao, times(1)).deleteById(1);
    }
    
    /*
    // JUnit test for save Book method
    @DisplayName("JUnit test for update user method")
    @Test
    public void testUpdateUser() throws ApplicationException{
       when(userDao.save(dummyUserEntity)).thenReturn(dummyUserEntity);

       UserPojo sendUserPojo = new UserPojo(1, "Joe", "Cool", "jcool@gmail.com", "password", "employee");
       UserPojo actualUserPojo = userService.updateUser(sendUserPojo);

       assertEquals(expectedUserPojo, actualUserPojo);
    }*/
    
    /*
    // JUnit test for save Book method
    @DisplayName("JUnit test for getUserByEmailAndPassword method")
    @Test
    public void testGetUserByEmailAndPassword() throws ApplicationException{
       when(userDao.findByUserEmailAndUserPassword(dummyUserEntity.getUserEmail(), dummyUserEntity.getUserPassword()).thenReturn(Optional.of(dummyUserEntity));
       UserPojo actualUserPojo = userService.getUserByEmailAndPassword(expectedUserPojo);
       assertEquals(expectedUserPojo, actualUserPojo);
    }*/
}
