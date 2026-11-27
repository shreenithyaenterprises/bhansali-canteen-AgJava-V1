package com.abc.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.abc.model.EmployeeMaster;

 public interface EmployeeMasterRepository extends CrudRepository<EmployeeMaster, String> {
	
	 List<EmployeeMaster> findBySite(String site);
	 
	@Query(nativeQuery = true, value="select empCode, Name, FH, DH, SH from emp_manger_mapping")
	public List<Map<String, Object>>  getEmpManagerMappingDtl();

	@Modifying
	@Query(nativeQuery = true, value="Update emp_manger_mapping Set SH=:shCode where empcode in :emplist")
	public int  UpdateEmpMappingSH(@Param("shCode") String shCode, List<String> emplist);
	
	@Modifying
	@Query(nativeQuery = true, value="Update emp_manger_mapping Set DH=:dhCode where empcode in :emplist")
	public int  UpdateEmpMappingDH(@Param("dhCode") String dhCode, List<String> emplist);
	
	@Modifying
	@Query(nativeQuery = true, value="Update emp_manger_mapping Set FH=:fhCode where EmpCode in :emplist")
	public int  UpdateEmpMappingFH(@Param("fhCode") String fhCode, List<String> emplist);
	
	@Query(nativeQuery = true, value="select concat(e.empcode, '-'"
			+ ", e.name) empcodename, e.empcode emp_code, e.name emp_name, d.department dept, m.dh approver_code from Employee e "
			+ "left join  department d on e.deptcode=d.deptcode "
			+ "inner join emp_manger_mapping m on ltrim(rtrim(e.empcode))=ltrim(rtrim(m.empcode)) "
			+ "where e.empcode in (select ltrim(rtrim(empcode)) from emp_manger_mapping  where (sh =:empcode or dh=:empcode or rtrim(ltrim(empcode))=:empcode )) ")
	public List<Map<String, Object>>  getEmployeeList(@Param("empcode") String empcode);
	
	@Query(nativeQuery = true, value="select concat(e.empcode, '-', e.name) empcodename,e.empcode emp_code, e.name emp_name, d.department dept, m.dh approver_code from Employee e left join  department d on e.deptcode=d.deptcode inner join emp_manger_mapping m on ltrim(rtrim(e.empcode))=ltrim(rtrim(m.empcode))")
	public List<Map<String, Object>>  getAllEmployeeList();
	
}