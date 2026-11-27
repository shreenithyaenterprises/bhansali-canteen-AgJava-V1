package com.abc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import com.abc.model.siteMaster;
import com.abc.service.siteMasterService;


 @RestController
 @RequestMapping("/site/")
 public class SiteMasterController implements CORSInterface
 {
	@Autowired
	siteMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<siteMaster> savesitemaster(@RequestBody siteMaster sitemaster) throws Exception,ServiceException
	{
		if(sitemaster == null)
			throw new Exception();
		try
		{
			service.Save(sitemaster);
		} catch (Exception e)
		{
			throw new ServiceException("Site Master Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Site Master Records Saved.",sitemaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<siteMaster> savesiteMaster(@RequestBody List<siteMaster> sitemaster) throws Exception,ServiceException
	{
		 if(sitemaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(sitemaster);
		} catch (Exception e)
		{
			throw new ServiceException("Site Master Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Site Master Records Saved.",sitemaster);
	}
	@RequestMapping(value = "getAllSite", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<siteMaster> getAllsiteMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Site Master Records Fetched.",service.getAllsiteMaster());
		} catch (Exception e)
		{
			throw new ServiceException("Site Master Service Error");
		}
	}
	@RequestMapping(value = "getsiteById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<siteMaster> getbyIdsiteMaster(@RequestBody siteMaster stMaster) throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Site Master Records Fetched.",service.getsiteMasterById(stMaster.getSite_code()));
		} catch (Exception e)
		{
			throw new ServiceException("Site Master Service Error");
		}
		
	
	}
	@RequestMapping(value = "deleteSiteById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEmployee(@RequestBody  siteMaster stMaster) throws ServiceException 
	{
		try
		{
		  service.delete(stMaster.getSite_code());
		} catch (Exception e)
		{
			throw new ServiceException("Site Master Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Site Master Records Deleted.");
	}
	
 }