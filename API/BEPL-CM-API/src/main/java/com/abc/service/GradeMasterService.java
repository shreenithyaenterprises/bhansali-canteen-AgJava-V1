package com.abc.service;

import java.util.List;
import com.abc.model.GradeMaster;

public interface GradeMasterService
{

	public List<GradeMaster> getAllGradeMaster();
	
	public GradeMaster getGradeMasterById(String Grade_code);
	
	public GradeMaster Save(GradeMaster grademaster);
	
	public List<GradeMaster> SaveAll(List<GradeMaster> grademaster);
	
	public void delete(String Grade_code);

}