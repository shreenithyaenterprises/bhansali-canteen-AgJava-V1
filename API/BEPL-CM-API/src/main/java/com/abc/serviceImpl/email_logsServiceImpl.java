package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.email_logs;
import com.abc.repository.email_logsRepository;
import com.abc.service.email_logsService;

@Service
@Transactional
public class email_logsServiceImpl implements email_logsService
{

	@Autowired
	email_logsRepository repo;
	
	@Override
	public List<email_logs> getAllemail_logs()
	{
		return (List<email_logs>) repo.findAll();
	}
	@Override
	public email_logs getemail_logsById(Long ID)
	{
		return repo.findById(ID).get();
	}
	@Override
	public email_logs Save(email_logs email_logs)
	{
		return repo.save(email_logs);
	}
	@Override
	public List<email_logs> SaveAll(List<email_logs> email_logs)
	{
		return (List<email_logs>) repo.saveAll(email_logs);
	}
	@Override
	public void delete(Long ID)
	{
		 repo.deleteById(ID);
	}
}
