package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.bean.payloadBean;
import com.abc.model.EmployeeMaster;


public interface EmployeeMasterService
{

	public List<EmployeeMaster> getAllEmployeeMaster();
	
	public List<EmployeeMaster> getAllEmployeebySite(String site);
	
	public EmployeeMaster getEmployeeMasterById(String EmpCode);
	
	public EmployeeMaster Save(EmployeeMaster employeemaster);
	
	public List<EmployeeMaster> SaveAll(List<EmployeeMaster> employeemaster);
	
	public void delete(String EmpCode);
	
	public List<Map<String, Object>> getEmployeeList(String empcode);
	
	public List<Map<String, Object>> getAllEmployeeList();
	
	public List<Map<String, Object>> getEmpMappingDtl();
	
	public int updateManagerMapping(payloadBean pb);

}