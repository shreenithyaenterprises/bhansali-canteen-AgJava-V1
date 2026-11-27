package com.abc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.abc.bean.Employee;
import com.abc.bean.payloadBean;
import com.abc.exceptionHandler.ServiceException;
import com.abc.model.ApiResponse;
import com.abc.model.EmployeeMaster;
import com.abc.service.EmployeeMasterService;
import com.abc.misc.CORSInterface;

 @RestController
 @RequestMapping("/employee/")
 public class EmployeeController implements CORSInterface
 {
	@Autowired
	EmployeeMasterService service;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmployeeMaster> saveemployeemaster(@RequestBody EmployeeMaster employeemaster) throws Exception,ServiceException
	{
		if(employeemaster == null)
			throw new Exception();
		try
		{
			System.out.println(employeemaster);
			service.Save(employeemaster);
		} catch (Exception e)
		{
			throw new ServiceException("Employee Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Employee Record Saved.",employeemaster);
	}
	@RequestMapping(value = "saveAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmployeeMaster> saveEmployeeMaster(@RequestBody List<EmployeeMaster> employeemaster) throws Exception,ServiceException
	{
		List<EmployeeMaster> empList= null;
		System.out.println("employeemaster:"+employeemaster);
		 if(employeemaster == null)
			 throw new Exception();
		
		try
		{
			
			empList = service.SaveAll(employeemaster);
		} catch (Exception e)
		{
			throw new ServiceException("Employee Service Error");
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "EmployeeMaster Records Saved.",empList);
	}
	@PostMapping(value = "getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmployeeMaster> getAllEmployeeMaster() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Fetched.",service.getAllEmployeeMaster());
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}
	@PostMapping(value = "getAllEmployeeBySite", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmployeeMaster> getAllEmployeeBySite(@RequestBody payloadBean pb) throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Fetched.",service.getAllEmployeebySite(pb.getSite()));
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}
	@RequestMapping(value = "getEmployeeById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<EmployeeMaster> getbyIdEmployeeMaster(@RequestBody EmployeeMaster employeemaster) throws ServiceException 
	{
		try
		{
			
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Fetched.",service.getEmployeeMasterById(employeemaster.getEmpcode()));
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}
	@RequestMapping(value = "deleteEmployeeById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Object> deletebyIdEmployeeMaster(@RequestBody EmployeeMaster employeemaster) throws ServiceException 
	{
		try
		{
		  System.out.println("key:"+employeemaster.getEmpcode());
		  service.delete(employeemaster.getEmpcode());
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
		 return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Deleted.");
	}
	@RequestMapping(value = "getEmployeeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Employee> getEmployeeList(@RequestBody payloadBean pb) throws ServiceException 
	{
		try
		{
			System.out.println("###getEmployeeList###");
			System.out.println(pb.toString());
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Fetched.",service.getEmployeeList(pb.getEmp_code()));
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}
	@RequestMapping(value = "getAllEmployeeList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Employee> getAllEmployeeList(@RequestBody payloadBean pb) throws ServiceException 
	{
		try
		{
			System.out.println("###getAllEmployeeList###");
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Records Fetched.",service.getAllEmployeeList());
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}	
	@RequestMapping(value = "getEmpMappingDtl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Employee> getEmpMappingDtl() throws ServiceException 
	{
		try
		{
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee Mapping Records Fetched.",service.getEmpMappingDtl());
		} catch (Exception e)
		{
			throw new ServiceException("EmployeeMaster Service Error");
		}
	}
	@RequestMapping(value = "updateEmpMapping", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<Employee> updateEmpMapping(@RequestBody payloadBean payload) throws ServiceException 
	{
		try
		{
			System.out.println(payload);
			return new ApiResponse<>(HttpStatus.OK.value(), "Employee mapping Updated.",service.updateManagerMapping(payload));
			
		} catch (Exception e)
		{
			throw new ServiceException("Employee Service Error");
		}
	}
 }