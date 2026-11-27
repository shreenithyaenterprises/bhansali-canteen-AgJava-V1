package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.EstablishmentMaster;
import com.abc.repository.EstablishmentMasterRepository;
import com.abc.service.EstablishmentMasterService;

@Service
@Transactional
public class EstablishmentMasterServiceImpl implements EstablishmentMasterService
{

	@Autowired
	EstablishmentMasterRepository repo;
	
	@Override
	public List<EstablishmentMaster> getAllEstablishmentMaster()
	{
		return (List<EstablishmentMaster>) repo.findAll();
	}
	@Override
	public EstablishmentMaster getEstablishmentMasterById(String code)
	{
		return repo.findById(code).get();
	}
	@Override
	public EstablishmentMaster Save(EstablishmentMaster establishmentmaster)
	{
		return repo.save(establishmentmaster);
	}
	@Override
	public List<EstablishmentMaster> SaveAll(List<EstablishmentMaster> establishmentmaster)
	{
		return (List<EstablishmentMaster>) repo.saveAll(establishmentmaster);
	}
	@Override
	public void delete(String code)
	{
		 repo.deleteById(code);
	}
}
