package com.abc.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.bean.role_details;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.ApiResponse;
import com.abc.model.user_profile;
import com.abc.service.user_profileService;
import com.abc.utility.Misc;
import com.abc.misc.CORSInterface;

 @RestController
 @RequestMapping("/user/")
 public class user_profileController implements CORSInterface
 {
	@Autowired
	user_profileService service;
	//@Autowired
	role_details lgnDetails;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> saveuser_profile(@RequestBody user_profile user_profile) throws Exception,ServiceException
	{
		if(user_profile == null)
			throw new Exception();
		try
		{
			service.Save(user_profile);
		} catch (Exception e)
		{
			throw new ServiceException("user_profile Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Saved.",user_profile);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> saveuser_profile(@RequestBody List<user_profile> user_profile) throws Exception,ServiceException
	{
		 if(user_profile == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(user_profile);
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Saved.",user_profile);
	}
	@RequestMapping(value = "validateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> AuthenticateUser(@RequestBody user_profile user_profile) throws ServiceException 
	{
		System.out.println("Validate Login.....");
		try
		{

			Map<String,Object> map = service.getloginUserDetails(user_profile.getUser_id(), user_profile.getPassword());
			map.put("days", Misc.LicenseRemainingDays());
			if (Objects.isNull(map))
				return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "User or Password in incorrect!, Please try again",null);

			return new ApiResponse<>(HttpStatus.OK.value(), "Authentication Success!",map);
		} catch (Exception e)
		{
			System.out.println(e.toString());
			throw new ServiceException("userprofile Service Error");
		}
	}
	@GetMapping(value = "getAlluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> getAlluser_profile() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Fetched.",service.getAlluser_profile());
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
	}
	@RequestMapping(value = "getuserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> getbyIduser_profile(@RequestBody user_profile user_profile) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Fetched.",service.getuser_profileById(user_profile.getUser_id()));
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
	}
	@RequestMapping(value = "deleteuserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIduser_profile(@RequestBody user_profile user_profile) throws ServiceException 
	{
		try
		{
		  service.delete(user_profile.getUser_id());
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Deleted.");
	}
	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> forgot_password(@RequestBody user_profile user_profile) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Fetched.",service.forgotPassword(user_profile.getUser_id()));
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
	}
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<user_profile> reset_password(@RequestBody user_profile uf) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "user_profile Records Fetched.",service.resetPassword(uf.getUser_id(),uf.getPassword()));
		} catch (Exception e)
		{
			throw new ServiceException("userprofile Service Error");
		}
	}
 }