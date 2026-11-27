package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.shiftMaster;
import com.abc.repository.shiftMasterRepository;
import com.abc.service.shiftMasterService;

@Service
@Transactional
public class shiftMasterServiceImpl implements shiftMasterService
{

	@Autowired
	shiftMasterRepository repo;
	
	@Override
	public List<shiftMaster> getAllshiftMaster()
	{
		return (List<shiftMaster>) repo.findAll();
	}
	@Override
	public shiftMaster getshiftMasterById(String shift_code)
	{
		return repo.findById(shift_code).get();
	}
	@Override
	public shiftMaster Save(shiftMaster shiftmaster)
	{
		return repo.save(shiftmaster);
	}
	@Override
	public List<shiftMaster> SaveAll(List<shiftMaster> shiftmaster)
	{
		return (List<shiftMaster>) repo.saveAll(shiftmaster);
	}
	@Override
	public void delete(String shift_code)
	{
		 repo.deleteById(shift_code);
	}
}
