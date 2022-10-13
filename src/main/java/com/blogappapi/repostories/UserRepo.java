package com.blogappapi.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogappapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
