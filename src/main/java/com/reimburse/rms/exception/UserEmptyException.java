package com.reimburse.rms.exception;

public class UserEmptyException extends Exception{

	@Override
	public String getMessage() {
		return "No Employees in database at this time";
	}
}
