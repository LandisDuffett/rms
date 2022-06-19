package com.reimburse.rms.exception;

public class RequestsNotFoundException extends Exception{

	int userId;
	
	public RequestsNotFoundException(int userid) {
		this.userId = userid;
	}
	
	@Override
	public String getMessage() {
		return "No current requests for user with id: " + userId +"";
	}
}