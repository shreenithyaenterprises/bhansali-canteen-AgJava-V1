package com.abc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.model.siteMaster;


public interface siteMasterService
{

	public List<siteMaster> getAllsiteMaster();
	
	public siteMaster getsiteMasterById(String site_code);
	
	public siteMaster Save(siteMaster sitemaster);
	
	public List<siteMaster> SaveAll(List<siteMaster> sitemaster);
	
	public void delete(String site_code);

}