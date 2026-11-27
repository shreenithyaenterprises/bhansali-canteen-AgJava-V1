package com.abc.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.EmailReport;
import com.abc.repository.EmailReportRepository;
import com.abc.service.EmailReportService;

@Service
@Transactional
public class EmailReportServiceImpl implements EmailReportService
{

	@Autowired
	EmailReportRepository repo; 
	
	@Override
	public List<EmailReport> getAllEmailReport()
	{
		return (List<EmailReport>) repo.findAll();
	}
	@Override
	public EmailReport getEmailReportById(Integer rpt_no)
	{
		return repo.findById(rpt_no).get();
	}
	@Override
	public EmailReport Save(EmailReport emailreport)
	{
		return repo.save(emailreport);
	}
	@Override
	public List<EmailReport> SaveAll(List<EmailReport> emailreport)
	{
		return (List<EmailReport>) repo.saveAll(emailreport);
	}
	@Override
	public void delete(Integer rpt_no)
	{
		 repo.deleteById(rpt_no);
	}
}
