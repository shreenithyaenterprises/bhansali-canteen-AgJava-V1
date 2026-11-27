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
import com.abc.model.departmentMaster;
import com.abc.service.departmentMasterService;
import com.abc.misc.CORSInterface;

 @RestController
 @RequestMapping("/department/")
 public class DepartmentController implements CORSInterface
 {
	@Autowired
	departmentMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<departmentMaster> savedepartmentmaster(@RequestBody departmentMaster departmentmaster) throws Exception,ServiceException
	{
		if(departmentmaster == null)
			throw new Exception();
		try
		{
			service.Save(departmentmaster);
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Saved.",departmentmaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<departmentMaster> savedepartmentMaster(@RequestBody List<departmentMaster> departmentmaster) throws Exception,ServiceException
	{
		 if(departmentmaster == null)
			 throw new Exception();
		 
		 List<departmentMaster> deptList=null;
		try
		{
			deptList = service.SaveAll(departmentmaster);
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Saved.",deptList);
	}
	@RequestMapping(value = "getAllDepartment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<departmentMaster> getAlldepartmentMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Fetched.",service.getAlldepartmentMaster());
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
	}
	@RequestMapping(value = "getDepartmentById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<departmentMaster> getbyIddepartmentMaster(@RequestBody departmentMaster departmentmaster) throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Fetched.",service.getdepartmentMasterById(departmentmaster.getDept_code()));
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteDepartmentById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIddepartmentMaster(@RequestBody departmentMaster departmentmaster) throws ServiceException 
	{
		try
		{
		  service.delete(departmentmaster.getDept_code());
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Deleted.");
	}
	@RequestMapping(value = "getDepartmentList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<departmentMaster> getdepartmentList() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "departmentMaster Records Fetched.",service.getDepartmentList());
		} catch (Exception e)
		{
			throw new ServiceException("departmentMaster Service Error");
		}
	}
 }