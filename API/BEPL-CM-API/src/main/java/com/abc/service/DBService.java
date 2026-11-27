package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.bean.payloadBean;

public interface DBService
{
	public List<Map<String, Object>> getSiteWiseCountByItem(payloadBean pb);
	
	public List<Map<String, Object>> getMealsSummaryDaily(payloadBean pb);
	
	public List<Map<String, Object>> getMealsSummaryMonthly(payloadBean pb);
	
	public List<Map<String, Object>> getMealsDetail(payloadBean pb);
	
	public List<Map<String, Object>> getMealsDetailMonthly(payloadBean pb);
	
	public List<Map<String, Object>> getIOCountDeptWise();
	
	public List<Map<String, Object>> getIOCountContWise();
	
	public List<Map<String, Object>> getSummaryReportbyDate(String from_date, String to_date);
	
	public List<Map<String, Object>> getIODetail(String areacode, String deptcode, String contcode, String shiftcode);

	public List<Map<String, Object>> getSummaryData(String status);
	
	public List<Map<String, Object>> getInsideData(String status);
	
	public List<Map<String, Object>> getIOMissing(String status);
}
