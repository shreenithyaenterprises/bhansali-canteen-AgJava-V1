package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import com.abc.model.meals;
import com.abc.service.mealsService;

 @RestController
 @RequestMapping("/meals/")
 public class mealsController implements CORSInterface
 {
	@Autowired
	mealsService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals> savemeals(@RequestBody meals meals) throws Exception,ServiceException
	{
		if(meals == null)
			throw new Exception();
		try
		{
			service.Save(meals);
		} catch (Exception e)
		{
			throw new ServiceException("meals Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "meals Records Saved.",meals);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals> savemeals(@RequestBody List<meals> meals) throws Exception,ServiceException
	{
		 if(meals == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(meals);
		} catch (Exception e)
		{
			throw new ServiceException("meals Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "meals Records Saved.",meals);
	}
	@GetMapping(value = "getAllMeals", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals> getAllmeals() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "meals Records Fetched.",service.getAllmeals());
		} catch (Exception e)
		{
			throw new ServiceException("meals Service Error");
		}
	}
	@RequestMapping(value = "getmealsById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<meals> getbyIdmeals(@RequestBody meals meals) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "meals Records Fetched.",service.getmealsById(meals.getMeal_code()));
		} catch (Exception e)
		{
			throw new ServiceException("meals Service Error");
		}
	}
	@RequestMapping(value = "deletemealsById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdmeals(@RequestBody meals meals) throws ServiceException 
	{
		try
		{
		  service.delete(meals.getMeal_code());
		} catch (Exception e)
		{
			throw new ServiceException("meals Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "meals Records Deleted.");
	}
	
 }