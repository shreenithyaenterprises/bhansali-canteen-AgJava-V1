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
import com.abc.model.EstablishmentMaster;
import com.abc.service.EstablishmentMasterService;

 @RestController
 @RequestMapping("/Establishment/")
 public class EstablishmentController implements CORSInterface
 {
	@Autowired
	EstablishmentMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EstablishmentMaster> saveestablishmentmaster(@RequestBody EstablishmentMaster establishmentmaster) throws Exception,ServiceException
	{
		if(establishmentmaster == null)
			throw new Exception();
		try
		{
			service.Save(establishmentmaster);
		} catch (Exception e)
		{
			throw new ServiceException("EstablishmentMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EstablishmentMaster Records Saved.",establishmentmaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EstablishmentMaster> saveEstablishmentMaster(@RequestBody List<EstablishmentMaster> establishmentmaster) throws Exception,ServiceException
	{
		 if(establishmentmaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(establishmentmaster);
		} catch (Exception e)
		{
			throw new ServiceException("EstablishmentMaster Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EstablishmentMaster Records Saved.",establishmentmaster);
	}
	@RequestMapping(value = "getAllEstablishment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EstablishmentMaster> getAllEstablishmentMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "EstablishmentMaster Records Fetched.",service.getAllEstablishmentMaster());
		} catch (Exception e)
		{
			throw new ServiceException("EstablishmentMaster Service Error");
		}
	}
	@RequestMapping(value = "getEstablishmentById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EstablishmentMaster> getbyIdEstablishmentMaster(@RequestBody EstablishmentMaster establishmentmaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Establishment Records Fetched.",service.getEstablishmentMasterById(establishmentmaster.getCode()));
		} catch (Exception e)
		{
			throw new ServiceException("EstablishmentMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteEstablishmentById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEstablishmentMaster(@RequestBody EstablishmentMaster establishmentmaster) throws ServiceException 
	{
		try
		{
		  service.delete(establishmentmaster.getCode());
		} catch (Exception e)
		{
			throw new ServiceException("EstablishmentMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "EstablishmentMaster Records Deleted.");
	}
	
 }