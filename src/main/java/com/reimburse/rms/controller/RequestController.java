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
import com.reimburse.rms.exception.RequestsNotFoundException;
import com.reimburse.rms.pojo.RequestPojo;
import com.reimburse.rms.service.RequestService;

@CrossOrigin //to enable cors
@RestController
@RequestMapping("api")
public class RequestController {
	
	//throws ApplicationException is incorrect here, have to handle the exceptions gracefully
	//this can be done using GlobalExceptionHandler - will be covered later
	@Autowired
	RequestService requestService;
	//create the rest methods for the rest endpoints
	//https://localhost:5555/api/books
	@GetMapping("requests")
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		return requestService.getAllRequests();
	}
	
	//http://localhost:5555/api/books/2
	@DeleteMapping("requests/{rid}")
	public boolean deleteRequest(@PathVariable("rid") int requestId) throws ApplicationException {
		return requestService.deleteRequest(requestId);
	}
	
	
	//books/2
	@GetMapping("requests/{rid}")
	public RequestPojo getARequest(@PathVariable("rid") int requestId) throws ApplicationException {
		return requestService.getARequest(requestId);
	}
	
	//https://localhost:555/api/books
	@PostMapping("requests")
	public RequestPojo addRequest(@Valid @RequestBody RequestPojo requestPojo) throws ApplicationException {
		return requestService.addRequest(requestPojo);
	}
	
	//https://localhost:555/api/books
	@PutMapping("requests")
	public RequestPojo updateRequest(@Valid @RequestBody RequestPojo requestPojo) throws ApplicationException {
		return requestService.updateRequest(requestPojo);
	}
	
	// http://localhost:5555/api/books/Comedy
	@GetMapping("requests/userid/{uid}")
	public List<RequestPojo> getRequestsByUserId(@PathVariable("uid") int uid) throws ApplicationException, RequestsNotFoundException {
		return requestService.getRequestsByUserId(uid);
			
	}
	
}
