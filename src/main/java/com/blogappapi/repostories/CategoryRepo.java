package com.blogappapi.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogappapi.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
