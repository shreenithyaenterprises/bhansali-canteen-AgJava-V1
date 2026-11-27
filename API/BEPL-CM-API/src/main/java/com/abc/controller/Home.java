package com.abc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.exceptionHandler.ServiceException;
import com.abc.model.ApiResponse;
import com.abc.misc.CORSInterface;

@RestController
@RequestMapping("/Home/")
public class Home implements CORSInterface
{
	@RequestMapping(value = "/verify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<String> getVerifyMessage(HttpServletResponse response, HttpServletRequest request,
			ModelMap model) throws  ServiceException
	{
		String msg=null;
		try
		{
			 msg = "Success";
		} catch (Exception ex)
		{
			throw new ServiceException("Internal Server Exception while getting exception");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",msg);
	}
}
