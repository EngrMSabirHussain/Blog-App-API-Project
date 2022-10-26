package com.blogappapi.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogappapi.entities.Category;
import com.blogappapi.execptions.ResourceNotFoundExecption;
import com.blogappapi.payloads.CategoryDto;
import com.blogappapi.repostories.CategoryRepo;
import com.blogappapi.services.CategoryServices;


@Service
public class CategoryServicesImpl implements CategoryServices {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category input=this.modelMapper.map(categoryDto, Category.class);
		Category save=this.categoryRepo.save(input);
		return this.modelMapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category input=this.modelMapper.map(categoryDto, Category.class);
		
		Category getRecord=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundExecption("Category","Category Id",categoryId));
		
		getRecord.setCategoryId(input.getCategoryId());
		getRecord.setCategoryName(input.getCategoryName());
		getRecord.setCategoryDescription(input.getCategoryDescription());
		
		Category update=this.categoryRepo.save(getRecord);
		
		
		return this.modelMapper.map(update, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category getRecord=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundExecption("Category", "Category Id", categoryId));
		return this.modelMapper.map(getRecord, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> getList=this.categoryRepo.findAll();
		return this.ListOfCategoryDto(getList);
	}

	@Override
	public void delCategory(Integer categoryId) {
		Category getDelUser=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundExecption("Category", "Category Id", categoryId));
		this.categoryRepo.delete(getDelUser);
	}

	@Override
	public void delAllCategory() {
		// TODO Auto-generated method stub

	}
	
	
	private List<CategoryDto> ListOfCategoryDto(List<Category> category) {
		
		List<CategoryDto> list = new ArrayList<CategoryDto>();
		for(Category l:category){
			list.add(this.modelMapper.map(l, CategoryDto.class));	
		}
			
		return list;
	}

}
