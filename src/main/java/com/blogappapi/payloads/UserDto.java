package com.blogappapi.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(max=10, message="Name can be only 10 chars")
	private String name;
	
	@Email(message="Email is invalid")
	private String email;
	
	@NotEmpty
	@Size(min=6, message="min password 6 chars")
	private String password;
	
	@NotEmpty(message="about session not be null or blank")
	private String about;
	
}
