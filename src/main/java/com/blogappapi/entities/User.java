package com.blogappapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_table")

@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name="user_name", nullable = false, length = 20)
	private String name;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_email" )
	private String email;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_about")
	private String about;
	
}
