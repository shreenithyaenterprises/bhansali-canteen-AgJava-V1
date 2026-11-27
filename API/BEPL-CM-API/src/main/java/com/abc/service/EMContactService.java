package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.model.EMContact;

public interface EMContactService  
{
	public List<Map<String, Object>> getAllEMContacts();
	
	public EMContact getEMContactbyId(int id);
	
	public EMContact Save(EMContact emContact);
	
	public List<EMContact> SaveAll(List<EMContact> emContact);
	
	public void delete(int ID);
}
