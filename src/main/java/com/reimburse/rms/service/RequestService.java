package com.reimburse.rms.service;

import java.util.List;

import com.reimburse.rms.pojo.RequestPojo;

public interface RequestService {
	
	RequestPojo addRequest(RequestPojo requestPojo);
	
	RequestPojo updateRequest(RequestPojo requestPojo);
	
	boolean deleteRequest(int requestId);
	
	List<RequestPojo> getAllRequests();
	
	RequestPojo getARequest(int requestId);
}
