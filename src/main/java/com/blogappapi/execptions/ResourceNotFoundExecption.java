package com.blogappapi.execptions;

public class ResourceNotFoundExecption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resource;
	String filed;
	int value;
	public ResourceNotFoundExecption(String resource, String filed, int value) {
		super(String.format("%s not found by %s: %d",resource,filed,value));
		this.filed = filed;
		this.resource = resource;
		this.value = value;
	}
	

}
