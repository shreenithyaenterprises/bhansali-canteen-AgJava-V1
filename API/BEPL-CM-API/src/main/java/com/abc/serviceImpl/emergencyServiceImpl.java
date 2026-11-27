package com.abc.serviceImpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.emergency;
import com.abc.repository.emergencyRepository;
import com.abc.service.emergencyService;

@Service
@Transactional
public class emergencyServiceImpl implements emergencyService
{

	@Autowired
	emergencyRepository repo;
	
	@Override
	public List<emergency> getAllemergency()
	{
		return (List<emergency>) repo.findAll();
	}
	@Override
	public emergency getemergencyById(Date date)
	{
		return repo.findById(date).get();
	}
	@Override
	public emergency Save(emergency emergency)
	{
		return repo.save(emergency);
	}
	@Override
	public List<emergency> SaveAll(List<emergency> emergency)
	{
		return (List<emergency>) repo.saveAll(emergency);
	}
	@Override
	public void delete(Date date)
	{
		 repo.deleteById(date);
	}
}
