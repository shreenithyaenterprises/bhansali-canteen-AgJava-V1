package com.abc;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.abc.model.AppConfig;
import com.abc.service.AppConfigService;

@Component
public class Startup
{
	@Autowired
	Environment enviroment;
	@Autowired
	AppConfigService appconfig;
	
	public static Map<String, String> enviromentProperties = new HashMap<>();
	public static Map<String, String> appConfig = new HashMap<>();
	
	@PostConstruct
	public void init()
	{
		getStartupProperties();
		AppConfigList();
	}
	private void getStartupProperties()
	{
		System.out.println("###############Environment Variables Initilization######################");
		enviromentProperties.put("smtpHost", enviroment.getProperty("email.smtpHost"));
		enviromentProperties.put("smtpPort", enviroment.getProperty("email.smtpPort"));
		enviromentProperties.put("smtpAuth", enviroment.getProperty("email.smtpAuth"));
		enviromentProperties.put("smtpSSL", enviroment.getProperty("email.smtpSSL"));
		enviromentProperties.put("emailId", enviroment.getProperty("email.accountId"));
		enviromentProperties.put("emailPass", enviroment.getProperty("email.accountPass"));
		enviromentProperties.put("emailBodyFP", enviroment.getProperty("email.fp.body"));
		enviromentProperties.put("emailSubjectFP", enviroment.getProperty("email.fp.subject"));
		enviromentProperties.put("emailBodyAttReg", enviroment.getProperty("email.AttReg.body"));
		enviromentProperties.put("emailSubjectAttReg", enviroment.getProperty("email.AttReg.subject"));
		
	}
	private void AppConfigList() 
	{
		System.out.println("###############AppConfig Initilization######################");
		try
		{
			for (AppConfig config : appconfig.getAllAppConfig())
			{
				appConfig.put(config.getVariable(),config.getValue());
				System.out.println(config.getVariable()+"::"+config.getValue());
			}
		} catch (Exception e)
		{
			System.out.println("Exception in Startup AppConfigList()" + e.toString());
		}
	}
}
