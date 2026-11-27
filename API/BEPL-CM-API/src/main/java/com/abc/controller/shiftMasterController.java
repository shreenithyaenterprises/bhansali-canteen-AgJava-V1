package com.abc.controller;

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
import com.abc.model.shiftMaster;
import com.abc.service.shiftMasterService;

 @RestController
 @RequestMapping("/shift/")
 public class shiftMasterController implements CORSInterface
 {
	@Autowired
	shiftMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<shiftMaster> saveshiftmaster(@RequestBody shiftMaster shiftmaster) throws Exception,ServiceException
	{
		if(shiftmaster == null)
			throw new Exception();
		try
		{
			service.Save(shiftmaster);
		} catch (Exception e)
		{
			throw new ServiceException("shiftMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "shiftMaster Records Saved.",shiftmaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<shiftMaster> saveshiftMaster(@RequestBody List<shiftMaster> shiftmaster) throws Exception,ServiceException
	{
		 if(shiftmaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(shiftmaster);
		} catch (Exception e)
		{
			throw new ServiceException("shiftMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "shiftMaster Records Saved.",shiftmaster);
	}
	@RequestMapping(value = "getAllshift", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<shiftMaster> getAllshiftMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "shiftMaster Records Fetched.",service.getAllshiftMaster());
		} catch (Exception e)
		{
			throw new ServiceException("shiftMaster Service Error");
		}
	}
	@RequestMapping(value = "getshiftMasterById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<shiftMaster> getbyIdshiftMaster(@RequestBody shiftMaster shiftmaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "shiftMaster Records Fetched.",service.getshiftMasterById(shiftmaster.getShift_code()));
		} catch (Exception e)
		{
			throw new ServiceException("shiftMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteShiftbyId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdshiftMaster(@RequestBody shiftMaster shiftmaster) throws ServiceException 
	{
		try
		{
		  service.delete(shiftmaster.getShift_code());
		} catch (Exception e)
		{
			throw new ServiceException("shiftMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "shiftMaster Records Deleted.");
	}
	
 }