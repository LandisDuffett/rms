package com.reimburse.rms.exception;

public class RequestEmptyException extends Exception {

	@Override
	public String getMessage() {
		return "No Reuqests at this time";
	}
}
