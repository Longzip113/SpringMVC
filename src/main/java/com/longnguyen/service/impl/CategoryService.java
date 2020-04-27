package com.longnguyen.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.longnguyen.entity.CategoryEntity;
import com.longnguyen.repository.CategoryRepository;
import com.longnguyen.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public Map<String, String> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		Map<String, String>  models = new HashMap<String, String>();
		for (CategoryEntity entity : entities) {
			models.put(entity.getCode(), entity.getName());
		}
		return models;
	}

	
}
