package com.abc.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bean.payloadBean;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.meals_timing;
import com.abc.service.meals_timingService;

 @RestController
 @RequestMapping("/mealsTiming/")
 public class meals_timingController implements CORSInterface
 {
	@Autowired
	meals_timingService service;
	
	@PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals_timing> savemeals_timing(@RequestBody meals_timing meals_timing) throws Exception,ServiceException
	{
		if(meals_timing == null)
			throw new Exception();
		try
		{
			service.Save(meals_timing);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new ServiceException("meals_timing Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Saved.",meals_timing);
	}
	@PostMapping(value = "saveAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals_timing> savemeals_timing(@RequestBody List<meals_timing> meals_timing) throws Exception,ServiceException
	{
		 if(meals_timing == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(meals_timing);
		} catch (Exception e)
		{
			throw new ServiceException("meals_timing Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Saved.",meals_timing);
	}
	@PostMapping(value = "getAllmealsTiming", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals_timing> getAllmeals_timing() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Fetched.",service.getAllmeals_timing());
		} catch (Exception e)
		{
			throw new ServiceException("meals_timing Service Error");
		}
	}
	@PostMapping(value = "getAllmealsTimingBySite", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals_timing> getAllmealsTimingBySite(@RequestBody payloadBean pb) throws ServiceException 
	{
		try
		{	
			return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Fetched.",service.getAllmealstimingBySite(pb.getSite()));
		} catch (Exception e)
		{
			throw new ServiceException("meals_timing Service Error");
		}
	}
	
	@PostMapping(value = "getmealsTimingById",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals_timing> getbyIdmeals_timing(@RequestBody meals_timing meals_timing) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Fetched.",service.getmeals_timingById(meals_timing.getMealCode()));
		} catch (Exception e)
		{
			throw new ServiceException("meals_timing Service Error");
		}
	}
	@PostMapping(value = "deletemealsTimingById", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdmeals_timing(@RequestBody meals_timing meals_timing) throws ServiceException 
	{
		try
		{
		  service.delete(meals_timing);
		} catch (Exception e)
		{
			throw new ServiceException("meals_timing Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "meals_timing Records Deleted.");
	}
	
 }