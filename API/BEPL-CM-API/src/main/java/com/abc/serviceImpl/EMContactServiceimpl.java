package com.abc.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abc.model.EMContact;
import com.abc.repository.EMContactRepository;
import com.abc.service.EMContactService;

@Service
public class EMContactServiceimpl implements EMContactService
{
	@Autowired
	EMContactRepository repo;
	
	@Override
	public List<Map<String, Object>> getAllEMContacts()
	{
		//return (List) repo.findAll();
		return repo.getAllEMContact();
	}
	@Override
	public EMContact getEMContactbyId(int id)
	{
		return repo.findById(id).get();
	}
	@Override
	public EMContact Save(EMContact emContact)
	{
		return repo.save(emContact);
	}
	@Override
	public List<EMContact> SaveAll(List<EMContact> emContact)
	{
		return (List) repo.saveAll(emContact);
	}
	@Override
	public void delete(int id)
	{
		repo.deleteById(id);
	}

}
