package io.s3soft.proxyapp.error.handler;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.s3soft.proxyapp.error.ApiError;
import io.s3soft.proxyapp.error.ApiValidationError;
import io.s3soft.proxyapp.exception.UserDataException;

/**
 * @author shaiksha
 *
 */
@ControllerAdvice
public class CustomExceptionErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({UserDataException.class})
	public ResponseEntity<Object> handleBindExceptions(UserDataException ex,WebRequest request){
		List<ApiValidationError> errorMessages=new ArrayList<ApiValidationError>();
		for(FieldError error: ex.getErrors().getFieldErrors()) {
			errorMessages.add(new ApiValidationError(error.getObjectName(),error.getField(),error.getRejectedValue(),error.getDefaultMessage()));
		}		
		
		ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST,ex.getMessage(),errorMessages);		
		return new ResponseEntity<Object>(apiError,apiError.getHttpStatus()) ;
	}

}
