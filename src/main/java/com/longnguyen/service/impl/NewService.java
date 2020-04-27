package com.longnguyen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.longnguyen.converter.NewConverter;
import com.longnguyen.dto.NewDTO;
import com.longnguyen.entity.CategoryEntity;
import com.longnguyen.entity.NewEntity;
import com.longnguyen.repository.CategoryRepository;
import com.longnguyen.repository.NewRepository;
import com.longnguyen.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		List<NewDTO> newDTOs = new ArrayList<NewDTO>();
		
		for (NewEntity newEntity : entities) {
			NewDTO dto = newConverter.toDTO(newEntity);
			newDTOs.add(dto);
		}
		return newDTOs;
	}

	@Override
	public Integer getTotalItem() {
		
		return (int)newRepository.count();
	}

	@Override
	public NewDTO findById(Long id) {
		NewEntity entity = newRepository.findOne(id);
		
		return newConverter.toDTO(entity);
	}

//	@Override
//	@Transactional //Kich hoat commit va rollback
//	public NewDTO insert(NewDTO dto) {
//		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
//		NewEntity newEntity = newConverter.toEntity(dto);
//		newEntity.setCategoryEntity(category);
//		return newConverter.toDTO(newRepository.save(newEntity));
//	}
//
//	@Override
//	@Transactional
//	public NewDTO updataNew(NewDTO dto) {
//		NewEntity oldNew = newRepository.findOne(dto.getId());
//		oldNew.setCategoryEntity(categoryRepository.findOneByCode(dto.getCategoryCode()));
//		NewEntity updataNew = newConverter.toEntity(oldNew, dto);
//		
//		return newConverter.toDTO(newRepository.save(updataNew));
//	}

	@Override
	@Transactional //Kich hoat commit va rollback
	public NewDTO newDTO(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity =  new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategoryEntity(categoryRepository.findOneByCode(dto.getCategoryCode()));
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto);
			newEntity.setCategoryEntity(category);
		}
		return newConverter.toDTO(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {
		for (Long id : ids) {
			newRepository.delete(id);
		}
	}
}
