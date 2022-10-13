package com.blogappapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogappapi.payloads.UserDto;
import com.blogappapi.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserServices userServices;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		UserDto createUser=this.userServices.createUser(userDto);
		
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<?> updateUserById(@RequestBody UserDto userDto,@PathVariable int userId){
		UserDto updateUser=this.userServices.updateUser(userDto, userId);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId) {
		try {
			UserDto getUser = this.userServices.getUserById(userId);
			return new ResponseEntity<>(getUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Record not Found", HttpStatus.NOT_FOUND);
		}

	}
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUser(){
		List<UserDto> userDto=this.userServices.getAllUsers();
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delUser/{userId}")
	public ResponseEntity<?> delUserById(@PathVariable int userId) {
		
		
		this.userServices.delUserById(userId);
		return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
//		try {
//			this.userServices.delUserById(userId);
//			return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>("Record not Found", HttpStatus.NOT_FOUND);
//		}

	}
	
	
	@DeleteMapping("/delAllUsers")
	public ResponseEntity<?> delAllUsers(){
		this.userServices.delAllUsers();
		return new ResponseEntity<>("Delete All Users Successfully", HttpStatus.OK);
	}
	
}
