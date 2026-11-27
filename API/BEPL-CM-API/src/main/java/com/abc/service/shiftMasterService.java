package com.abc.service;

import java.util.List;
import com.abc.model.shiftMaster;

public interface shiftMasterService
{

	public List<shiftMaster> getAllshiftMaster();
	
	public shiftMaster getshiftMasterById(String shift_code);
	
	public shiftMaster Save(shiftMaster shiftmaster);
	
	public List<shiftMaster> SaveAll(List<shiftMaster> shiftmaster);
	
	public void delete(String shift_code);

}