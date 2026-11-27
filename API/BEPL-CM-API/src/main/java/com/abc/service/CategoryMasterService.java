package com.abc.service;

import java.util.List;
import com.abc.model.CategoryMaster;

public interface CategoryMasterService
{

	public List<CategoryMaster> getAllCategoryMaster();
	
	public CategoryMaster getCategoryMasterById(String Category_code);
	
	public CategoryMaster Save(CategoryMaster categorymaster);
	
	public List<CategoryMaster> SaveAll(List<CategoryMaster> categorymaster);
	
	public void delete(String Category_code);

}