package com.blogappapi.execptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogappapi.payloads.ApiResponce;

@RestControllerAdvice
public class GlobleExecptionHandeller {
	
	
	@ExceptionHandler(ResourceNotFoundExecption.class)
	public ResponseEntity<ApiResponce> ResourceNotFoundExecptionHandler(ResourceNotFoundExecption ex){
		String message=ex.getMessage();
		ApiResponce responce=new ApiResponce(message,false,404);	
		return new ResponseEntity<>(responce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String FieldName=((FieldError)error).getField();
			String FieldError=error.getDefaultMessage();
			errors.put(FieldName, FieldError);	
		});
		return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
	}

}
