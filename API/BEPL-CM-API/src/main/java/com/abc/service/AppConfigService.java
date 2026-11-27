package com.abc.service;

import java.util.List;
import com.abc.model.AppConfig;

public interface AppConfigService
{

	public List<AppConfig> getAllAppConfig();
	
	public AppConfig getAppConfigById(int primaryKey);
	
	public AppConfig Save(AppConfig tableObject);
	
	public List<AppConfig> SaveAll(List<AppConfig> appconfig);
	
	public void delete(int primaryKey);

}