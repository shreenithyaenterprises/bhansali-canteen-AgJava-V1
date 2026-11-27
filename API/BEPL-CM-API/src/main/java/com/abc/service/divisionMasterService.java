package com.abc.service;

import java.util.List;
import com.abc.model.divisionMaster;

public interface divisionMasterService
{

	public List<divisionMaster> getAlldivisionMaster();
	
	public divisionMaster getdivisionMasterById(String division_code);
	
	public divisionMaster Save(divisionMaster divisionmaster);
	
	public List<divisionMaster> SaveAll(List<divisionMaster> divisionmaster);
	
	public void delete(String division_code);

}