package com.reimburse.rms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

import com.reimburse.rms.dao.RequestDao;
import com.reimburse.rms.entity.RequestEntity;
import com.reimburse.rms.exception.ApplicationException;
import com.reimburse.rms.exception.RequestEmptyException;
import com.reimburse.rms.exception.RequestsNotFoundException;
import com.reimburse.rms.pojo.RequestPojo;
import com.reimburse.rms.service.RequestService;
import com.reimburse.rms.service.RequestServiceImpl;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class RequestServiceTest {
	
	@Mock
	RequestDao requestDao;
	
	@InjectMocks
	RequestServiceImpl requestService;
	
	private RequestPojo expectedRequestPojo;
	private RequestEntity dummyRequestEntity;
	
	
	@BeforeEach
	public void setup() {
		expectedRequestPojo = new RequestPojo(2, 10, 100, "something", "resolved", "image", "", "");
		dummyRequestEntity = new RequestEntity(2, 10, 100, "something", "resolved", "image", "", "");
	}
	
	
	@DisplayName("JUnit test for add request meethod")
	@Test
	public void testAddRequest() throws ApplicationException {
		RequestEntity dummyRequestEntity = new RequestEntity(2, 10, 100, "something", "resolved", "image", "", "");
		when(requestDao.saveAndFlush(any(RequestEntity.class))).thenReturn(dummyRequestEntity); 
		
		RequestPojo sendRequestPojo = new RequestPojo(2, 10, 100, "something", "resolved", "image", "", "");
		RequestPojo actualRequestPojo = requestService.addRequest(sendRequestPojo);
		
		assertEquals(2, actualRequestPojo.getRequestId());
	}
	
	
	 // JUnit test for getAllBooks method
    @DisplayName("JUnit test for getAllRequests method")
    @Test
    public void testGetAllRequests() throws ApplicationException, RequestEmptyException {
        when(requestDao.findAll()).thenReturn(List.of(dummyRequestEntity, dummyRequestEntity));
   
        List<RequestPojo> actualAllRequestPojoList = requestService.getAllRequests();

        assertNotNull(actualAllRequestPojoList);
        assertEquals(2, actualAllRequestPojoList.size());
    }
    
    // JUnit test for getABook method
    @DisplayName("JUnit test for getARequest method")
    @Test
    public void testGetARequest() throws ApplicationException {
    	when(requestDao.findById(1)).thenReturn(Optional.of(dummyRequestEntity));
    	RequestPojo actualRequestPojo = requestService.getARequest(1);
    	assertEquals(expectedRequestPojo, actualRequestPojo);
    }
   
    
 // JUnit test for getABook method
    @DisplayName("JUnit test for getRequestsByUserId method")
    @Test
    public void testGetRequestsByUserId() throws ApplicationException, RequestsNotFoundException {
    	when(requestDao.findByRequestUserId(1)).thenReturn(List.of(dummyRequestEntity, dummyRequestEntity));
    	 List<RequestPojo> actualAllRequestPojoList = requestService.getRequestsByUserId(1);

         assertNotNull(actualAllRequestPojoList);
         assertEquals(2, actualAllRequestPojoList.size());
    }
    
    // JUnit test for deleteBook method
    @DisplayName("JUnit test for deleteRequest method")
    @Test
    public void testDeleteRequest() throws ApplicationException {
    	doNothing().when(requestDao).deleteById(1);
    	requestService.deleteRequest(1);
    	verify(requestDao, times(1)).deleteById(1);
    }

    
    // JUnit test for save Book method
    @DisplayName("JUnit test for update request method")
    @Test
    public void testUpdateRequest() throws ApplicationException{
       when(requestDao.save(any(RequestEntity.class))).thenReturn(dummyRequestEntity);

       RequestPojo sendRequestPojo = new RequestPojo(2, 10, 100, "something", "resolved", "image", "", "");
       RequestPojo actualRequestPojo = requestService.updateRequest(sendRequestPojo);

       assertEquals(expectedRequestPojo, actualRequestPojo);
    }
}
