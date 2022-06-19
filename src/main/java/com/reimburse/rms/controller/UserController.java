package com.reimburse.rms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.exception.UserEmptyException;
import com.reimburse.rms.exception.UserNotFoundException;
import com.reimburse.rms.pojo.UserPojo;
import com.reimburse.rms.service.UserService;

@CrossOrigin //to enable cors
@RestController
@RequestMapping("api")
public class UserController {
	
	//throws ApplicationException is incorrect here, have to handle the exceptions gracefully
	//this can be done using GlobalExceptionHandler - will be covered later
	@Autowired
	UserService userService;
	//create the rest methods for the rest endpoints
	//https://localhost:5555/api/books
	@GetMapping("users")
	public List<UserPojo> getAllUsers() throws ApplicationException, UserEmptyException {
		return userService.getAllUsers();
	}
	
	//http://localhost:5555/api/books/2
	@DeleteMapping("users/{uid}")
	public boolean deleteUser(@PathVariable("uid") int userId) throws ApplicationException {
		return userService.deleteUser(userId);
	}
	
	//books/2
	@PostMapping("users/email/password")
	public UserPojo getUserByEmaiilAndPassword(@RequestBody UserPojo userPojo) throws ApplicationException, UserNotFoundException {
		return userService.getUserByEmailAndPassword(userPojo);
	}
	
	//https://localhost:555/api/books
	@PostMapping("users")
	public UserPojo addUser(@Valid @RequestBody UserPojo userPojo) throws ApplicationException {
		return userService.addUser(userPojo);
	}
	
	//https://localhost:555/api/books
	@PutMapping("users")
	public UserPojo updateUser(@Valid @RequestBody UserPojo userPojo) throws ApplicationException {
		return userService.updateUser(userPojo);
	}
	
}