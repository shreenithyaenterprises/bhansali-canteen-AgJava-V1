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
import com.abc.model.GradeMaster;
import com.abc.service.GradeMasterService;
import com.abc.misc.CORSInterface;


 @RestController
 @RequestMapping("/grade/")
 public class GradeController implements CORSInterface
 {
	@Autowired
	GradeMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<GradeMaster> savegrademaster(@RequestBody GradeMaster grademaster) throws Exception,ServiceException
	{
		if(grademaster == null)
			throw new Exception();
		try
		{
			service.Save(grademaster);
		} catch (Exception e)
		{
			throw new ServiceException("Grade Master Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Grade Master Records Saved.",grademaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<GradeMaster> saveGradeMaster(@RequestBody List<GradeMaster> grademaster) throws Exception,ServiceException
	{
		 if(grademaster == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(grademaster);
		} catch (Exception e)
		{
			throw new ServiceException("Grade Master Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "GradeMaster Records Saved.",grademaster);
	}
	@RequestMapping(value = "getAllGrade", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<GradeMaster> getAllGradeMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "GradeMaster Records Fetched.",service.getAllGradeMaster());
		} catch (Exception e)
		{
			throw new ServiceException("Grade Master Service Error");
		}
	}
	@RequestMapping(value = "getGradeById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<GradeMaster> getbyIdGradeMaster(@RequestBody GradeMaster grademaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Grade Master Records Fetched.",service.getGradeMasterById(grademaster.getGrade_code()));
		} catch (Exception e)
		{
			throw new ServiceException("Grade Master Service Error");
		}
	}
	@RequestMapping(value = "deleteGradeById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdGradeMaster(@RequestBody GradeMaster grademaster) throws ServiceException 
	{
		try
		{
		  service.delete(grademaster.getGrade_code());
		} catch (Exception e)
		{
			throw new ServiceException("Grade Master Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Grade Master Records Deleted.");
	}
	
 }