package com.abc.service;

import java.util.Date;
import java.util.List;
import com.abc.model.emergency;

public interface emergencyService
{

	public List<emergency> getAllemergency();
	
	public emergency getemergencyById(Date date);
	
	public emergency Save(emergency emergency);
	
	public List<emergency> SaveAll(List<emergency> emergency);
	
	public void delete(Date date);

}