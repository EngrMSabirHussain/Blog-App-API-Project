package com.blogappapi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogappapi.entities.User;
import com.blogappapi.execptions.ResourceNotFoundExecption;
import com.blogappapi.payloads.UserDto;
import com.blogappapi.repostories.UserRepo;
import com.blogappapi.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto user) {
		User save1=userDtoToUser(user);
		return this.userToUserDto(this.userRepo.save(save1));
	}

	@Override
	public UserDto getUserById(int userId) {
		User user=this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundExecption("User","Id",userId));

		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> user=this.userRepo.findAll();
		
		return this.userListToUserDtoList(user);
	}

	
	
	@Override
	public UserDto updateUser(UserDto user, int userId) {
		User getUser=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundExecption("User","Id",userId));
		
		getUser.setAbout(user.getAbout());
		getUser.setEmail(user.getEmail());
		getUser.setName(user.getName());
		getUser.setPassword(user.getPassword());
		
		User updateUser=this.userRepo.save(getUser);
		
		return this.userToUserDto(updateUser);
	}

	

	
	@Override
	public void delUserById(int userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundExecption("User","Id",userId));
		
		this.userRepo.delete(user);	
	}

	
	@Override
	public void delAllUsers() {
		this.userRepo.deleteAll();
		
	}

	
	private UserDto userToUserDto(User user) {
		
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
//		UserDto userDto=new UserDto();
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
		
		return userDto;
	}
	
	private User userDtoToUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto, User.class);
//		User user=new User();
//		user.setAbout(userDto.getAbout());
//		user.setEmail(userDto.getEmail());
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
		
		return user;
	}

	private List<UserDto> userListToUserDtoList(List<User> user){
		List<UserDto> userDto=new ArrayList<UserDto>();
		
		for(User user1:user) {
			userDto.add(this.userToUserDto(user1));
		}
		return userDto;
	}
	
}
