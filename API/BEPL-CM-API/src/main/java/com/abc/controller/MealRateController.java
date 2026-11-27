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
import com.abc.model.MealRate;
import com.abc.service.MealRateService;

 @RestController
 @RequestMapping("/MealsRate/")
 public class MealRateController implements CORSInterface
 {
	@Autowired
	MealRateService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<MealRate> savemealrate(@RequestBody MealRate mealrate) throws Exception,ServiceException
	{
		if(mealrate == null)
			throw new Exception();
		try
		{
			service.Save(mealrate);
		} catch (Exception e)
		{
			throw new ServiceException("MealRate Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "MealRate Records Saved.",mealrate);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<MealRate> saveMealRate(@RequestBody List<MealRate> mealrate) throws Exception,ServiceException
	{
		 if(mealrate == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(mealrate);
		} catch (Exception e)
		{
			throw new ServiceException("MealRate Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "MealRate Records Saved.",mealrate);
	}
	@RequestMapping(value = "getAllMealRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<MealRate> getAllMealRate() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "MealRate Records Fetched.",service.getAllMealRate());
		} catch (Exception e)
		{
			throw new ServiceException("MealRate Service Error");
		}
	}
	@RequestMapping(value = "getMealRateById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<MealRate> getbyIdMealRate(@RequestBody MealRate mr) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "MealRate Records Fetched.",service.getMealRateById(mr.getSr_no()));
		} catch (Exception e)
		{
			throw new ServiceException("MealRate Service Error");
		}
	}
	@RequestMapping(value = "deleteMealRateById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdMealRate(@RequestBody MealRate mr) throws ServiceException 
	{
		try
		{
		  service.delete(mr.getSr_no());
		} catch (Exception e)
		{
			throw new ServiceException("MealRate Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "MealRate Records Deleted.");
	}
	
 }