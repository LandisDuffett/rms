package com.reimburse.rms.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.reimburse.rms.exception.RequestsNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	// here we define the handlers globally for any of the the exceptions that would occur in the project
	
	// exception handler for MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 Map<String, String> errors = new HashMap<>();
		    ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError)error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
		    // return response entity, by doing we can manipulate the response header and status if required
		    return new ResponseEntity<Object>(errors, headers, status);
	}
	
	@ExceptionHandler(RequestsNotFoundException.class)
	protected ResponseEntity<Object> handleRequestsNotFoundException(RequestsNotFoundException ex) { // changed the argument list to the exception(removed headers, status, request)
		 Map<String, String> errors = new HashMap<>();										// which was the cause for the 500 internal error	
		 System.out.println(errors);
		 errors.put("date", LocalDate.now()+"");
		 errors.put("error", ex.getMessage());
		 System.out.println(errors);
		 return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) { // changed the argument list to the exception(removed headers, status, request)
		 Map<String, String> errors = new HashMap<>();										// which was the cause for the 500 internal error	
		 System.out.println(errors);
		 errors.put("date", LocalDate.now()+"");
		 errors.put("error", ex.getMessage());
		 System.out.println(errors);
		 return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}



