package com.longnguyen.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.longnguyen.dto.NewDTO;
import com.longnguyen.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	@Autowired
	INewService newService;
	
	//@RequestBody dung để map json qua newdto giống hàm httputil bên servelt 


	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.newDTO(newDTO);
	}
	
	@PutMapping("/api/new")
	public NewDTO updataNew(@RequestBody NewDTO updataNew) {
		return newService.newDTO(updataNew);
	}
	
	//Nhân vô một mảng id để xóa bài viết
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody Long[] ids) {
		newService.delete(ids);
	}
}
