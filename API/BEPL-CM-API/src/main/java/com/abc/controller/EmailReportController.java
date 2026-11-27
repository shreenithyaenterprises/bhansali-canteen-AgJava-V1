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
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import com.abc.model.EmailReport;
import com.abc.service.EmailReportService;

 @RestController
 @RequestMapping("/EmailReport/")
 public class EmailReportController implements CORSInterface
 {
	@Autowired
	EmailReportService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmailReport> saveemailreport(@RequestBody EmailReport emailreport) throws Exception,ServiceException
	{
		if(emailreport == null)
			throw new Exception();
		try
		{
			service.Save(emailreport);
		} catch (Exception e)
		{
			throw new ServiceException("EmailReport Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EmailReport Records Saved.",emailreport);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmailReport> saveEmailReport(@RequestBody List<EmailReport> emailreport) throws Exception,ServiceException
	{
		 if(emailreport == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(emailreport);
		} catch (Exception e)
		{
			throw new ServiceException("EmailReport Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EmailReport Records Saved.",emailreport);
	}
	@RequestMapping(value = "getEmailReport", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmailReport> getAllEmailReport() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "EmailReport Records Fetched.",service.getAllEmailReport());
		} catch (Exception e)
		{
			throw new ServiceException("EmailReport Service Error");
		}
	}
	@RequestMapping(value = "getEmailReportById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmailReport> getbyIdEmailReport(@RequestBody EmailReport er) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "EmailReport Records Fetched.",service.getEmailReportById(er.getRpt_no()));
		} catch (Exception e)
		{
			throw new ServiceException("EmailReport Service Error");
		}
	}
	@RequestMapping(value = "deleteEmailReportById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEmailReport(@RequestBody EmailReport er) throws ServiceException 
	{
		try
		{
		  service.delete(er.getRpt_no());
		} catch (Exception e)
		{
			throw new ServiceException("EmailReport Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "EmailReport Records Deleted.");
	}
	
 }