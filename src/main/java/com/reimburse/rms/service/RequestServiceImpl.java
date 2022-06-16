package com.reimburse.rms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimburse.rms.dao.RequestDao;
import com.reimburse.rms.entity.RequestEntity;
import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.exception.RequestsNotFoundException;
import com.reimburse.rms.pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	RequestDao requestDao;
	
	public RequestServiceImpl() {		
		
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws ApplicationException {
		//copy the pojo into an entity object
		RequestEntity requestEntity = new RequestEntity();
		BeanUtils.copyProperties(requestPojo, requestEntity);
				
		//now pass the bookEntity object to spring data jpa to be inserted into the table
		RequestEntity returnedRequestEntity = requestDao.saveAndFlush(requestEntity);
		requestPojo.setRequestId(returnedRequestEntity.getRequestId());
		return requestPojo;
	}

	@Override
	public RequestPojo updateRequest(RequestPojo requestPojo) throws ApplicationException {
		RequestEntity requestEntity = new RequestEntity();
		BeanUtils.copyProperties(requestPojo, requestEntity);
		
		RequestEntity returnedRequestEntity = requestDao.save(requestEntity);
		
		return requestPojo;
	}

	@Override
	public boolean deleteRequest(int requestId) throws ApplicationException {
		requestDao.deleteById(requestId);
		return true;
	}

	@Override
	public List<RequestPojo> getAllRequests() throws ApplicationException {
		List<RequestEntity> allRequestsEntity = requestDao.findAll();
		//now we have to copy each book entity object in the collection to a 
		//collection of book pojos
		//create an empty collection of book pojos
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		for(RequestEntity fetchedRequestEntity: allRequestsEntity) {
			RequestPojo returnRequestPojo = new RequestPojo(fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getRequestUserId(), 
					fetchedRequestEntity.getRequestAmount(), fetchedRequestEntity.getRequestDescription(), fetchedRequestEntity.getRequestStatus(), 
					fetchedRequestEntity.getRequestImagURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
			allRequestsPojo.add(returnRequestPojo);
		}
		return allRequestsPojo;
	}

	@Override
	public RequestPojo getARequest(int requestId) throws ApplicationException {
		Optional<RequestEntity> requestEntityOpt = requestDao.findById(requestId);
		RequestPojo requestPojo = null;
		if(requestEntityOpt.isPresent()) {
			//take out the entity object which is wrapped into the optional object
			RequestEntity fetchedRequestEntity = requestEntityOpt.get();
			//copy the entity into the pojo
			requestPojo = new RequestPojo(fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getRequestUserId(), 
					fetchedRequestEntity.getRequestAmount(), fetchedRequestEntity.getRequestDescription(), fetchedRequestEntity.getRequestStatus(), 
					fetchedRequestEntity.getRequestImagURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
			//bookPojo = new BookPojo();
			//BeanUtils.copyProperties(fetchedBookEntity, bookPojo); //nested copying will not take place
		}
		return requestPojo;
	}
	
	@Override
	public List<RequestPojo> getRequestsByUserId(int userid) throws ApplicationException, RequestsNotFoundException {
		List<RequestEntity> allRequestsEntity = requestDao.findByRequestUserId(userid);
		// now we have to copy each book entity object in the collection to a collection on book pojo
		// create a empty collection of book pojo
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		if(allRequestsEntity.size() > 0) {
		for(RequestEntity fetchedRequestEntity: allRequestsEntity) {
			RequestPojo returnRequestPojo = new RequestPojo(fetchedRequestEntity.getRequestId(), fetchedRequestEntity.getRequestUserId(), 
					fetchedRequestEntity.getRequestAmount(), fetchedRequestEntity.getRequestDescription(), fetchedRequestEntity.getRequestStatus(), 
					fetchedRequestEntity.getRequestImagURL(), fetchedRequestEntity.getRequestTime(), fetchedRequestEntity.getResolvedTime());
					allRequestsPojo.add(returnRequestPojo);
		}} else {
			throw new RequestsNotFoundException(userid);
		}
		return allRequestsPojo;
	}

}
