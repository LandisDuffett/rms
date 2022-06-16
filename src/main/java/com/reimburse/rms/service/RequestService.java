package com.reimburse.rms.service;

import java.util.List;

import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.exception.RequestsNotFoundException;
import com.reimburse.rms.pojo.RequestPojo;

public interface RequestService {
	
	RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException;
	
	RequestPojo updateRequest(RequestPojo requestPojo) throws ApplicationException;
	
	boolean deleteRequest(int requestId) throws ApplicationException;
	
	List<RequestPojo> getAllRequests() throws ApplicationException;
	
	RequestPojo getARequest(int requestId) throws ApplicationException;
	
	List<RequestPojo> getRequestsByUserId(int uid) throws ApplicationException, RequestsNotFoundException;
}
