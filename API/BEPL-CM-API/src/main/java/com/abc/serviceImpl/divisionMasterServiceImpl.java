package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.divisionMaster;
import com.abc.repository.divisionMasterRepository;
import com.abc.service.divisionMasterService;

@Service
@Transactional
public class divisionMasterServiceImpl implements divisionMasterService
{

	@Autowired
	divisionMasterRepository repo;
	
	@Override
	public List<divisionMaster> getAlldivisionMaster()
	{
		return (List<divisionMaster>) repo.findAll();
	}
	@Override
	public divisionMaster getdivisionMasterById(String division_code)
	{
		return repo.findById(division_code).get();
	}
	@Override
	public divisionMaster Save(divisionMaster divisionmaster)
	{
		return repo.save(divisionmaster);
	}
	@Override
	public List<divisionMaster> SaveAll(List<divisionMaster> divisionmaster)
	{
		return (List<divisionMaster>) repo.saveAll(divisionmaster);
	}
	@Override
	public void delete(String division_code)
	{
		 repo.deleteById(division_code);
	}
}
