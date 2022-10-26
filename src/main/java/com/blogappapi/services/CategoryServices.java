package com.blogappapi.services;

import java.util.List;

import com.blogappapi.payloads.CategoryDto;

public interface CategoryServices {
	
	//create category
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update category by id
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//read category by id
	CategoryDto getCategory(Integer categoryId);
	
	//read All category
	List<CategoryDto> getAllCategory();
	
	//delete category by id
	void delCategory(Integer categoryId);
	
	//delete all category
	void delAllCategory();
	
	
	

}
