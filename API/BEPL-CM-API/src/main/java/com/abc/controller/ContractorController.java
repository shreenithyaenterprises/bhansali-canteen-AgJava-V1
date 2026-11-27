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
import com.abc.model.Contractor;
import com.abc.service.ContractorService;

 @RestController
 @RequestMapping("/contractor/")
 public class ContractorController implements CORSInterface
 {
	@Autowired
	ContractorService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Contractor> savecontractor(@RequestBody Contractor contractor) throws Exception,ServiceException
	{
		if(contractor == null)
			throw new Exception();
		try
		{
			service.Save(contractor);
		} catch (Exception e)
		{
			throw new ServiceException("contractor Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "contractor Records Saved.",contractor);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Contractor> savecontractor(@RequestBody List<Contractor> contractor) throws Exception,ServiceException
	{
		 if(contractor == null)
			 throw new Exception();
		 
		List<Contractor> contList=null;
		try
		{
			contList=service.SaveAll(contractor);
		} catch (Exception e)
		{
			throw new ServiceException("contractor Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "contractor Records Saved.",contList);
	}
	@RequestMapping(value = "getAllContractor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Contractor> getAllcontractor() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "contractor Records Fetched.",service.getAllcontractor());
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("contractor Service Error");
		}
	}
	@RequestMapping(value = "getcontractorById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Contractor> getbyIdcontractor(@RequestBody Contractor cont) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "contractor Records Fetched.",service.getcontractorById(cont.getCont_code()));
		} catch (Exception e)
		{
			throw new ServiceException("contractor Service Error");
		}
	}
	@RequestMapping(value = "deleteContractorbyId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdcontractor(@RequestBody Contractor contractor) throws ServiceException 
	{
		try
		{
		  service.delete(contractor.getCont_code());
		} catch (Exception e)
		{
			throw new ServiceException("contractor Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "contractor Records Deleted.");
	}
	
 }