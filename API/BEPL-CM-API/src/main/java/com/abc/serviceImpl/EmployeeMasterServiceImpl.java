package com.abc.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.bean.payloadBean;
import com.abc.model.EmployeeMaster;
import com.abc.repository.EmployeeMasterRepository;
import com.abc.repository.GenericDAO;
import com.abc.service.EmployeeMasterService;
import com.abc.utility.Misc;

@Service
@Transactional
public class EmployeeMasterServiceImpl implements EmployeeMasterService
{

	@Autowired
	EmployeeMasterRepository repo;
	@Autowired
	GenericDAO dao;
	
	@Override
	public List<EmployeeMaster> getAllEmployeeMaster()
	{
		return (List<EmployeeMaster>) repo.findAll();
	}
	@Override
	public List<EmployeeMaster> getAllEmployeebySite(String site)
	{
		return (List<EmployeeMaster>) repo.findBySite(site);
	}
	@Override
	public  List<Map<String, Object>> getEmployeeList(String empcode)
	{
		try
		{
			return repo.getEmployeeList(empcode);//dao.getDataMap(sSQL);//dao.getJSONData(sSQL);
		}  catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public EmployeeMaster getEmployeeMasterById(String EmpCode)
	{
		return repo.findById(EmpCode).get();
	}
	@Override
	public EmployeeMaster Save(EmployeeMaster employeemaster)
	{
		return repo.save(employeemaster);
	}
	@Override
	public List<EmployeeMaster> SaveAll(List<EmployeeMaster> employeemaster)
	{
		return (List<EmployeeMaster>) repo.saveAll(employeemaster);
	}
	@Override
	public void delete(String EmpCode)
	{
		 repo.deleteById(EmpCode);
	}
	@Override
	public List<Map<String, Object>> getEmpMappingDtl()
	{
		return repo.getEmpManagerMappingDtl();
	}
	@Override
	public int updateManagerMapping(payloadBean pb)
	{
		JSONArray arr = new JSONArray();
		int rc=0;
		List<String> lstEmp = new ArrayList<String>();
		JSONObject json = new JSONObject(pb);
		String mgr = "";//pb.getStatus();
		String newMgr = pb.getEmp_code();
		arr = json.getJSONArray("lstdata");
		for (Object jo: arr)
		{
			JSONObject myJSONObject = (JSONObject) jo;
			lstEmp.add(myJSONObject.getString("empCode").replaceAll("\\s+",""));
		}
		if (mgr.equalsIgnoreCase("SH"))
		{
			rc=repo.UpdateEmpMappingSH(newMgr,lstEmp);
		}
		else if (mgr.equalsIgnoreCase("DH"))
		{
			rc=repo.UpdateEmpMappingDH(newMgr,lstEmp);
			
		}else if (mgr.equalsIgnoreCase("FH"))
		{
			rc=repo.UpdateEmpMappingFH(newMgr,lstEmp);
		}
		System.out.println("Affected Rows: "+rc);
		return rc;
	}
	@Override
	public List<Map<String, Object>> getAllEmployeeList()
	{
		try
		{
			return repo.getAllEmployeeList();
		}  catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
