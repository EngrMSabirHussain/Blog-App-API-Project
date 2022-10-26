package com.blogappapi.payloads;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponce {
	
	private String message;
	private boolean status;
	private int statusCode;
}
