package com.abc.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.abc.bean.payloadBean;


public interface ReportService 
{
	public List<Map<String, Object>> getSummaryReportbyDate(String from_date, String to_date, String site);
	
	public List<Map<String, Object>> getExceptionReportbyDate(String from_date, String to_date, String dept, String site);
	
	public List<Map<String, Object>> getDepartmentSummarybyDate(String from_date, String to_date, String dept, String site);
	
	public List<Map<String, Object>> getDeptwiseCountbyDate(String from_date, String to_date, String dept, String site);
	
	public List<Map<String, Object>> getPersonSummarybyDate(String from_date, String to_date, String code, String site);
	
	public List<Map<String, Object>> getMealSummarybyDate(String from_date, String to_date, String code, String site);
	
	public List<Map<String, Object>> getDatewiseEmpMeals(payloadBean pb);
	
	public List<Map<String, Object>> getMealAggregateByDate(payloadBean pb);
	
	public List<Map<String, Object>> getDaysofTheMonth(payloadBean pb);
	
	public List<Map<String, Object>> getUnregisteredUser(payloadBean pb);
	
	public Stream<LocalDate> getDaysBetween(payloadBean pb);
	
	public Stream<LocalDate> getDatesbBetweenfromAndTo(payloadBean pb);
}
