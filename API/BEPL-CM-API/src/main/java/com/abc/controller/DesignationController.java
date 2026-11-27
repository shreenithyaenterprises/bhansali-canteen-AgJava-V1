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
import com.abc.model.DesignationMaster;
import com.abc.service.DesignationMasterService;
import com.abc.misc.CORSInterface;


 @RestController
 @RequestMapping("/designation/")
 public class DesignationController implements CORSInterface
 {
	@Autowired
	DesignationMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<DesignationMaster> savedesignationmaster(@RequestBody DesignationMaster designationmaster) throws Exception,ServiceException
	{
		if(designationmaster == null)
			throw new Exception();
		try
		{
			service.Save(designationmaster);
		} catch (Exception e)
		{
			throw new ServiceException("Designation Master Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Designation Master Records Saved.",designationmaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<DesignationMaster> saveDesignationMaster(@RequestBody List<DesignationMaster> designationmaster) throws Exception,ServiceException
	{
		 if(designationmaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(designationmaster);
		} catch (Exception e)
		{
			throw new ServiceException("DesignationMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Designation Master Records Saved.",designationmaster);
	}
	@RequestMapping(value = "getAllDesignation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<DesignationMaster> getAllDesignationMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Designation Master Records Fetched.",service.getAllDesignationMaster());
		} catch (Exception e)
		{
			throw new ServiceException("DesignationMaster Service Error");
		}
	}
	@RequestMapping(value = "getDesignationById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<DesignationMaster> getbyIdDesignationMaster(@RequestBody DesignationMaster designationmaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Designation Master Records Fetched.",service.getDesignationMasterById(designationmaster.getDesignation_code()));
		} catch (Exception e)
		{
			throw new ServiceException("DesignationMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteDesignationById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdDesignationMaster(@RequestBody DesignationMaster designationmaster) throws ServiceException 
	{
		try
		{
		  service.delete(designationmaster.getDesignation_code());
		} catch (Exception e)
		{
			throw new ServiceException("DesignationMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Designation Master Records Deleted.");
	}
	
 }