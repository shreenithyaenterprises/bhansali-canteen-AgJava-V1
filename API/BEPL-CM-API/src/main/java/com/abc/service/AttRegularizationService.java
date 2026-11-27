package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.model.AttRegularization;

public interface AttRegularizationService
{

	public List<AttRegularization> getAllAttRegularization();
	
	public AttRegularization getAttRegularizationById(String req_no);
	
	public AttRegularization ProcessRequest(AttRegularization attregularization);
	
	public List<AttRegularization> SaveAll(List<AttRegularization> attregularization);
	
	public void delete(String req_no);
	
	public List<Map<String, Object>> getAttendancebyEmployee(String empCode, String monthYear);
	
	public List<Map<String, Object>> getRegRequestforMGRApproval(String empCode);
	
	public List<Map<String, Object>> getRegRequestforAdminApproval();
	
	public List<Map<String, Object>> getApprovedorRejectedRegRequest();
	
	public String ApproveorRejectbyMGR(String req_no, String approval_status, String approval_dt);
	
	public String ApproveorRejectbyAdmin(String req_no, String approval_status, String approval_dt);

}