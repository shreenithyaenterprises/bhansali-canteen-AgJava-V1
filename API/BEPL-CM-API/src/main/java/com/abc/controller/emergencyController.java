package com.abc.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.emergency;
import com.abc.service.emergencyService;

 @RestController
 @RequestMapping("/emergency/")
 public class emergencyController implements CORSInterface
 {
	@Autowired
	emergencyService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<emergency> saveemergency(@RequestBody emergency emergency) throws Exception,ServiceException
	{
		if(emergency == null)
			throw new Exception();
		try
		{
			emergency.setCreated_date( new Timestamp(System.currentTimeMillis()));
			service.Save(emergency);
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("emergency Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "emergency Records Saved.",emergency);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<emergency> saveemergency(@RequestBody List<emergency> emergency) throws Exception,ServiceException
	{
		 if(emergency == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(emergency);
		} catch (Exception e)
		{
			throw new ServiceException("emergency Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "emergency Records Saved.",emergency);
	}
	@RequestMapping(value = "getAllemergency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<emergency> getAllemergency() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "emergency Records Fetched.",service.getAllemergency());
		} catch (Exception e)
		{
			throw new ServiceException("emergency Service Error");
		}
	}
	@RequestMapping(value = "getemergencyById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<emergency> getbyIdemergency(@RequestBody emergency emergency) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "emergency Records Fetched.",service.getemergencyById(emergency.getCreated_date()));
		} catch (Exception e)
		{
			throw new ServiceException("emergency Service Error");
		}
	}
	@RequestMapping(value = "deleteemergencyById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdemergency(@RequestBody emergency emergency) throws ServiceException 
	{
		try
		{
		  service.delete(emergency.getCreated_date());
		} catch (Exception e)
		{
			throw new ServiceException("emergency Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "emergency Records Deleted.");
	}
	
 }