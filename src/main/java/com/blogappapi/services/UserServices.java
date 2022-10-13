package com.blogappapi.services;

import java.util.List;

import com.blogappapi.payloads.UserDto;

public interface UserServices {
	
	UserDto createUser(UserDto user);
	
	UserDto getUserById(int userId);
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto user, int userId);
	
	void delUserById(int UserId);
	void delAllUsers();
	
}
