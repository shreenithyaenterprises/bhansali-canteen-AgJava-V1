package com.abc.controller;

import java.util.List;

import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bean.payloadBean;
import com.abc.exceptionHandler.ServiceException;
import com.abc.misc.CORSInterface;
import com.abc.model.ApiResponse;
import com.abc.model.Device;
import com.abc.service.DeviceService;

 @RestController
 @RequestMapping("/device/")
 public class DeviceController implements CORSInterface
 {
	@Autowired
	DeviceService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Device> savedevice(@RequestBody Device device) throws Exception,ServiceException
	{
		if(device == null)
			throw new Exception();
		try
		{
			service.Save(device);
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Saved.",device);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Device> saveDevice(@RequestBody List<Device> device) throws Exception,ServiceException
	{
		 if(device == null)
			 throw new Exception();
		
		try
		{
			service.SaveAll(device);
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Saved.",device);
	}
	@PostMapping(value = "getAllDevice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Device> getAllDevice() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Fetched.",service.getAllDevice());
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
	}
	@PostMapping(value = "getAllDeviceBySite", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Device> getAllDeviceBySite(@RequestBody payloadBean pb) throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Fetched.",service.getAllDeviceBySite(pb.getSite()));
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
	}
	@RequestMapping(value = "getDeviceById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Device> getbyIdDevice(@RequestBody Device device) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Fetched.",service.getDeviceById(device.getIp_address()));
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
	}
	@RequestMapping(value = "deleteDevicebyId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdDevice(@RequestBody Device device) throws ServiceException 
	{
		try
		{
		  service.delete(device.getIp_address());
		} catch (Exception e)
		{
			throw new ServiceException("Device Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Device Records Deleted.");
	}
	
 }