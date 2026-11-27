package com.abc.service;

import java.util.List;
import com.abc.model.DesignationMaster;

public interface DesignationMasterService
{

	public List<DesignationMaster> getAllDesignationMaster();
	
	public DesignationMaster getDesignationMasterById(String Designation_code);
	
	public DesignationMaster Save(DesignationMaster designationmaster);
	
	public List<DesignationMaster> SaveAll(List<DesignationMaster> designationmaster);
	
	public void delete(String Designation_code);

}