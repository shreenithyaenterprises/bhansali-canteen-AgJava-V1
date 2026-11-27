package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.siteMaster;
import com.abc.repository.siteMasterRepository;
import com.abc.service.siteMasterService;

@Service
public class siteMasterServiceImpl implements siteMasterService
{

	@Autowired
	siteMasterRepository repo;
	
	@Override
	public List<siteMaster> getAllsiteMaster()
	{
		return (List<siteMaster>) repo.findAll();
	}
	@Override
	public siteMaster getsiteMasterById(String site_code)
	{
		return repo.findById(site_code).get();
	}
	@Override
	public siteMaster Save(siteMaster sitemaster)
	{
		return repo.save(sitemaster);
	}
	@Override
	public List<siteMaster> SaveAll(List<siteMaster> sitemaster)
	{
		return (List<siteMaster>) repo.saveAll(sitemaster);
	}
	@Override
	public void delete(String site_code)
	{
		 repo.deleteById(site_code);
	}

}
