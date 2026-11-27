package com.abc.service;

import java.util.List;
import com.abc.model.Contractor;

public interface ContractorService
{

	public List<Contractor> getAllcontractor();
	
	public Contractor getcontractorById(String cont_code);
	
	public Contractor Save(Contractor contractor);
	
	public List<Contractor> SaveAll(List<Contractor> contractor);
	
	public void delete(String cont_code);

}