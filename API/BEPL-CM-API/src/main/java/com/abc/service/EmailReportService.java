package com.abc.service;

import java.util.List;
import com.abc.model.EmailReport;

public interface EmailReportService
{

	public List<EmailReport> getAllEmailReport();
	
	public EmailReport getEmailReportById(Integer rpt_no);
	
	public EmailReport Save(EmailReport emailreport);
	
	public List<EmailReport> SaveAll(List<EmailReport> emailreport);
	
	public void delete(Integer rpt_no);

}