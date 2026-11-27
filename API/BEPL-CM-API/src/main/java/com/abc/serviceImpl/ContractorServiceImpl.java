package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.abc.model.Contractor;
import com.abc.repository.contractorRepository;
import com.abc.service.ContractorService;

@Service
@Transactional
public class ContractorServiceImpl implements ContractorService
{

	@Autowired
	contractorRepository repo;
	
	@Override
	public List<Contractor> getAllcontractor()
	{
		return (List<Contractor>) repo.findAll();
	}
	@Override
	public Contractor getcontractorById(String cont_code)
	{
		return repo.findById(cont_code).get();
	}
	@Override
	public Contractor Save(Contractor contractor)
	{
		return repo.save(contractor);
	}
	@Override
	public List<Contractor> SaveAll(List<Contractor> contractor)
	{
		return (List<Contractor>) repo.saveAll(contractor);
	}
	@Override
	public void delete(String cont_code)
	{
		 repo.deleteById(cont_code);
	}
}
