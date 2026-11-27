package com.abc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.ApiResponse;
import com.abc.model.CategoryMaster;
import com.abc.service.CategoryMasterService;
import com.abc.misc.CORSInterface;


 @RestController
 @RequestMapping("/category/")
 public class CategoryController implements CORSInterface
 {
	@Autowired
	CategoryMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<CategoryMaster> savecategorymaster(@RequestBody CategoryMaster categorymaster) throws Exception,ServiceException
	{
		if(categorymaster == null)
			throw new Exception();
		try
		{
			service.Save(categorymaster);
		} catch (Exception e)
		{
			throw new ServiceException("CategoryMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "CategoryMaster Records Saved.",categorymaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<CategoryMaster> saveCategoryMaster(@RequestBody List<CategoryMaster> categorymaster) throws Exception,ServiceException
	{
		 if(categorymaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(categorymaster);
		} catch (Exception e)
		{
			throw new ServiceException("CategoryMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "CategoryMaster Records Saved.",categorymaster);
	}
	@RequestMapping(value = "getAllCategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<CategoryMaster> getAllCategoryMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "CategoryMaster Records Fetched.",service.getAllCategoryMaster());
		} catch (Exception e)
		{
			throw new ServiceException("CategoryMaster Service Error");
		}
	}
	@RequestMapping(value = "getCategoryById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<CategoryMaster> getbyIdCategoryMaster(@RequestBody CategoryMaster categorymaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "CategoryMaster Records Fetched.",service.getCategoryMasterById(categorymaster.getCategory_code()));
		} catch (Exception e)
		{
			throw new ServiceException("CategoryMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteCategoryById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdCategoryMaster(@RequestBody CategoryMaster categorymaster) throws ServiceException 
	{
		try
		{
		  service.delete(categorymaster.getCategory_code());
		} catch (Exception e)
		{
			throw new ServiceException("CategoryMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "CategoryMaster Records Deleted.");
	}
	
 }