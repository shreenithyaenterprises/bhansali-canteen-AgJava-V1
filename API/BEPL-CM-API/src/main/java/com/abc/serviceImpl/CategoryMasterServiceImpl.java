package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.CategoryMaster;
import com.abc.repository.CategoryMasterRepository;
import com.abc.service.CategoryMasterService;

@Service
@Transactional
public class CategoryMasterServiceImpl implements CategoryMasterService
{

	@Autowired
	CategoryMasterRepository repo;
	
	@Override
	public List<CategoryMaster> getAllCategoryMaster()
	{
		return (List<CategoryMaster>) repo.findAll();
	}
	@Override
	public CategoryMaster getCategoryMasterById(String Category_code)
	{
		return repo.findById(Category_code).get();
	}
	@Override
	public CategoryMaster Save(CategoryMaster categorymaster)
	{
		return repo.save(categorymaster);
	}
	@Override
	public List<CategoryMaster> SaveAll(List<CategoryMaster> categorymaster)
	{
		return (List<CategoryMaster>) repo.saveAll(categorymaster);
	}
	@Override
	public void delete(String Category_code)
	{
		 repo.deleteById(Category_code);
	}
}
