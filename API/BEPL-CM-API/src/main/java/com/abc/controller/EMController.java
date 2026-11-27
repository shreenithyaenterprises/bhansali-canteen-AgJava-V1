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
import com.abc.model.EMContact;
import com.abc.service.EMContactService;
import com.abc.misc.CORSInterface;

 @RestController
 @RequestMapping("/EMContact/")
 public class EMController implements CORSInterface
 {
	@Autowired
	EMContactService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EMContact> saveemployeemaster(@RequestBody EMContact em) throws Exception,ServiceException
	{
		if(em == null)
			throw new Exception();
		try
		{
			System.out.println(em);
			service.Save(em);
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("EMContact Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EMContact Record Saved.",em);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EMContact> saveEmployeeMaster(@RequestBody List<EMContact> emList) throws Exception,ServiceException
	{
		 if(emList == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(emList);
		} catch (Exception e)
		{
			throw new ServiceException("EMContact Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EMContact Records Saved.",emList);
	}
	@RequestMapping(value = "getAllEMContact", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EMContact> getAllEMContact() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "All EMContact Records Fetched.",service.getAllEMContacts());
		} catch (Exception e)
		{
			throw new ServiceException("EMContact Service Error");
		}
	}
	@RequestMapping(value = "getEMContactById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EMContact> getbyIdEmployeeMaster(@RequestBody EMContact em) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "EMContact Records Fetched.",service.getEMContactbyId(em.getSr_no()));
		} catch (Exception e)
		{
			throw new ServiceException("EMContact Service Error");
		}
	}
	@RequestMapping(value = "deleteEMContactById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEmployeeMaster(@RequestBody EMContact em) throws ServiceException 
	{
		try
		{
		  service.delete(em.getSr_no());
		} catch (Exception e)
		{
			throw new ServiceException("EMContact Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "EMContact Records Deleted.");
	}
	
 }