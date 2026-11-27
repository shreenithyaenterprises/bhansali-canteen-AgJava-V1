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
import com.abc.model.divisionMaster;
import com.abc.service.divisionMasterService;
import com.abc.misc.CORSInterface;


 @RestController
 @RequestMapping("/division/")
 public class DivisionController implements CORSInterface
 {
	@Autowired
	divisionMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<divisionMaster> savedivisionmaster(@RequestBody divisionMaster divisionmaster) throws Exception,ServiceException
	{
		if(divisionmaster == null)
			throw new Exception();
		try
		{
			service.Save(divisionmaster);
		} catch (Exception e)
		{
			throw new ServiceException("divisionMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "divisionMaster Records Saved.",divisionmaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<divisionMaster> savedivisionMaster(@RequestBody List<divisionMaster> divisionmaster) throws Exception,ServiceException
	{
		 if(divisionmaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(divisionmaster);
		} catch (Exception e)
		{
			throw new ServiceException("divisionMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Division Records Saved.",divisionmaster);
	}
	@RequestMapping(value = "getAllDivision", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<divisionMaster> getAlldivisionMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Division Records Fetched.",service.getAlldivisionMaster());
		} catch (Exception e)
		{
			throw new ServiceException("divisionMaster Service Error");
		}
	}
	@RequestMapping(value = "getdivisionMasterById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<divisionMaster> getbyIddivisionMaster(@RequestBody divisionMaster divisionmaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Division Records Fetched.",service.getdivisionMasterById(divisionmaster.getDivision_code()));
		} catch (Exception e)
		{
			throw new ServiceException("divisionMaster Service Error");
		}
	}
	@RequestMapping(value = "deletedivisionMasterById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEmployee(@RequestBody divisionMaster divisionmaster) throws ServiceException 
	{
		try
		{
		  service.delete(divisionmaster.getDivision_code());
		} catch (Exception e)
		{
			throw new ServiceException("Division Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Division Deleted.");
	}
	
 }