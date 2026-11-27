package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.GradeMaster;
import com.abc.repository.GradeMasterRepository;
import com.abc.service.GradeMasterService;

@Service
@Transactional
public class GradeMasterServiceImpl implements GradeMasterService
{

	@Autowired
	GradeMasterRepository repo;
	
	@Override
	public List<GradeMaster> getAllGradeMaster()
	{
		return (List<GradeMaster>) repo.findAll();
	}
	@Override
	public GradeMaster getGradeMasterById(String Grade_code)
	{
		return repo.findById(Grade_code).get();
	}
	@Override
	public GradeMaster Save(GradeMaster grademaster)
	{
		return repo.save(grademaster);
	}
	@Override
	public List<GradeMaster> SaveAll(List<GradeMaster> grademaster)
	{
		return (List<GradeMaster>) repo.saveAll(grademaster);
	}
	@Override
	public void delete(String Grade_code)
	{
		 repo.deleteById(Grade_code);
	}
}
