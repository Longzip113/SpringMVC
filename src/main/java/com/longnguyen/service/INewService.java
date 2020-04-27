package com.longnguyen.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.longnguyen.dto.NewDTO;


public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	Integer getTotalItem();
	NewDTO findById(Long id);
//	NewDTO insert(NewDTO dto);
//	NewDTO updataNew(NewDTO dto);
	NewDTO newDTO(NewDTO dto);
	void delete(Long[] ids);
}
