package com.longnguyen.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstracsDTO<T> {

	private Long id;
	private Timestamp createdData;
	private Timestamp modifiedData;
	private String createdBy;
	private String modifiedBy;
	private Long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Integer page;
	private Integer limit; //So item tren mot page
	private Integer totalPage; // tong so page
	private Integer totalItem; // tong so page
	private String sortName;
	private String sortBy;
	private String message;
	private String alert;
	private String type;
	//Hiển thị danh sách bài viết type = list;
	//thêm sữa xóa bài biết type = edit; 
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getCreatedData() {
		return createdData;
	}
	public void setCreatedData(Timestamp createdData) {
		this.createdData = createdData;
	}
	public Timestamp getModifiedData() {
		return modifiedData;
	}
	public void setModifiedData(Timestamp modifiedData) {
		this.modifiedData = modifiedData;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
	
}
