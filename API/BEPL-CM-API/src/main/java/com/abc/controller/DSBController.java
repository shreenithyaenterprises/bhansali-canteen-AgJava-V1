package com.abc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bean.payloadBean;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.ApiResponse;
import com.abc.model.EMContact;
import com.abc.model.divisionMaster;
import com.abc.service.DBService;
import com.abc.misc.CORSInterface;

 @RestController
 @RequestMapping("/dsb/")
 public class DSBController implements CORSInterface
 {
	@Autowired
	DBService service;
	
	@PostMapping(value = "getAllSiteCountByItem",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getAllSiteCountByItem(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getAllSiteCountByItem<<<");

		try
		{
			List<Map<String, Object>> response=service.getSiteWiseCountByItem(pb);
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Count by Site Records fetched.",response);
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getMealsSummaryDaily", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealsSummaryDaily(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealsSummaryDaily<<<");

		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Head Count Records fetched.",service.getMealsSummaryDaily(pb));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getMealsSummaryMonthly",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealsSummaryMonthly(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealsSummaryMonthly<<<");

		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Head Count Records fetched.",service.getMealsSummaryMonthly(pb));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@PostMapping(value = "getMealsDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealsDetail(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealsDetail<<<");

		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Details fetched.",service.getMealsDetail(pb));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}	
	@PostMapping(value = "getMealsDetailMonthly", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getMealsDetailMonthly(@RequestBody payloadBean pb) throws Exception,ServiceException
	{
		System.out.println(">>>getMealsDetailMonthly<<<");

		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Meals Details fetched.",service.getMealsDetailMonthly(pb));
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}
	@GetMapping(value = "getIOCountContWise", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<payloadBean> getIOCountContWise() throws Exception,ServiceException
	{
		System.out.println(">>>getIOCountContWise<<<");

		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Head Count Records fetched.",service.getIOCountContWise());
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("Head Count Service Error");
		}
	}


 }