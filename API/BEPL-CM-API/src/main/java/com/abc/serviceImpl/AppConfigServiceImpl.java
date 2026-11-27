package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.AppConfig;
import com.abc.repository.AppConfigRepository;
import com.abc.service.AppConfigService;

@Service
@Transactional
public class AppConfigServiceImpl implements AppConfigService
{

	@Autowired
	AppConfigRepository repo;
	
	@Override
	public List<AppConfig> getAllAppConfig()
	{
		return (List<AppConfig>) repo.findAll();
	}
	@Override
	public AppConfig getAppConfigById(int primaryKey)
	{
		return repo.findById(primaryKey).get();
	}
	@Override
	public AppConfig Save(AppConfig tableObject)
	{
		return repo.save(tableObject);
	}
	@Override
	public List<AppConfig> SaveAll(List<AppConfig> appconfig)
	{
		return (List<AppConfig>) repo.saveAll(appconfig);
	}
	@Override
	public void delete(int srno)
	{
		 repo.deleteById(srno);
	}

}
