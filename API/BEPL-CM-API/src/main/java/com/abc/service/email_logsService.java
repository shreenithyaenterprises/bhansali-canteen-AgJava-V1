package com.abc.service;

import java.util.List;
import com.abc.model.email_logs;

public interface email_logsService
{

	public List<email_logs> getAllemail_logs();
	
	public email_logs getemail_logsById(Long ID);
	
	public email_logs Save(email_logs email_logs);
	
	public List<email_logs> SaveAll(List<email_logs> email_logs);
	
	public void delete(Long ID);

}