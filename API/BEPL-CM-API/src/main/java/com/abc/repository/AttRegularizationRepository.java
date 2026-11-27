package com.abc.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abc.model.AttRegularization;

public interface AttRegularizationRepository extends CrudRepository<AttRegularization, String> {
	
	
	@Query(nativeQuery = true, value="select * from Vw_getAttDetailsbyEmp where empcode=:emp_code and month(punch_date)=:month and year(punch_date)=:year")
	public List<Map<String, Object>>  getAttendancebyEmployee(@Param("emp_code") String emp_code, @Param("month") String month, @Param("year") String year);

	@Query(nativeQuery = true, value="select * from att_regularization where mgr_approver_code=:emp_code and (mgr_approval is null or mgr_approval='0')")
	public List<Map<String, Object>>  getRegRequestforMGRApproval(@Param("emp_code") String emp_code);

	@Query(nativeQuery = true, value="select * from att_regularization where mgr_approval='1' and (admin_approval is null or admin_approval='0')")
	public List<Map<String, Object>>  getRegRequestforAdminApproval();

	@Query(nativeQuery = true, value="select * from att_regularization where (mgr_approval='1' or mgr_approval='2') and (admin_approval='1' or admin_approval='2')")
	public List<Map<String, Object>>  getApprovedorRejectedRegRequest();
	
	@Modifying
	@Query(nativeQuery = true, value="update att_regularization Set mgr_approval=:approval, mgr_approval_dt=:approval_dt where req_no=:req_no")
	public int  ApproveorRejectbyMGR(@Param("req_no") String req_no, @Param("approval") String approval, @Param("approval_dt") String approval_dt);

	@Modifying
	@Query(nativeQuery = true, value="update att_regularization Set admin_approval=:approval, admin_approval_dt=:approval_dt where req_no=:req_no")
	public int  ApproveorRejectbyAdmin(@Param("req_no") String req_no, @Param("approval") String approval, @Param("approval_dt") String approval_dt);

}