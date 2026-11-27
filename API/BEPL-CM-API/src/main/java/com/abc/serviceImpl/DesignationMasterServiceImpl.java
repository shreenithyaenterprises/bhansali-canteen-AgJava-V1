package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.DesignationMaster;
import com.abc.repository.DesignationMasterRepository;
import com.abc.service.DesignationMasterService;

@Service
@Transactional
public class DesignationMasterServiceImpl implements DesignationMasterService
{

	@Autowired
	DesignationMasterRepository repo;
	
	@Override
	public List<DesignationMaster> getAllDesignationMaster()
	{
		return (List<DesignationMaster>) repo.findAll();
	}
	@Override
	public DesignationMaster getDesignationMasterById(String Designation_code)
	{
		return repo.findById(Designation_code).get();
	}
	@Override
	public DesignationMaster Save(DesignationMaster designationmaster)
	{
		return repo.save(designationmaster);
	}
	@Override
	public List<DesignationMaster> SaveAll(List<DesignationMaster> designationmaster)
	{
		return (List<DesignationMaster>) repo.saveAll(designationmaster);
	}
	@Override
	public void delete(String Designation_code)
	{
		 repo.deleteById(Designation_code);
	}
}
