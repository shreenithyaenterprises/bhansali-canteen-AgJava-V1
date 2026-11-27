package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.model.departmentMaster;

public interface departmentMasterService
{

	public List<departmentMaster> getAlldepartmentMaster();
	
	public departmentMaster getdepartmentMasterById(String dept_code);
	
	public departmentMaster Save(departmentMaster departmentmaster);
	
	public List<departmentMaster> SaveAll(List<departmentMaster> departmentmaster);
	
	public void delete(String dept_code);
	
	public List<Map<String, Object>> getDepartmentList();

}