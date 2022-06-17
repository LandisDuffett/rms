package com.reimburse.rms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.SystemException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reimburse.rms.dao.RequestDao;
import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.pojo.RequestPojo;
import com.reimburse.rms.service.RequestService;
import com.reimburse.rms.service.RequestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {
	
	@Mock
	private RequestDao daoMock;
	
	@InjectMocks
	private RequestServiceImpl service;
	
	@Test
	public void testGetARequest() {
		RequestService requestService = new RequestServiceImpl();
		
		RequestPojo expectedPojo = new RequestPojo(1, 5, 50, "stuff", "pending", "picture", "now", "later");
		RequestPojo actualPojo = null;
		try {
			actualPojo = requestService.getARequest(1);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expectedPojo, actualPojo);
	}
}
