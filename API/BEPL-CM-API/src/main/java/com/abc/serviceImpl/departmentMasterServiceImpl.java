package com.abc.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.abc.model.departmentMaster;
import com.abc.repository.GenericDAO;
import com.abc.repository.departmentMasterRepository;
import com.abc.service.departmentMasterService;

@Service
@Transactional
public class departmentMasterServiceImpl implements departmentMasterService
{

	@Autowired
	departmentMasterRepository repo;

	@Autowired
	GenericDAO dao;
	
	@Override
	public List<departmentMaster> getAlldepartmentMaster()
	{
		return (List<departmentMaster>) repo.findAll();
	}
	@Override
	public departmentMaster getdepartmentMasterById(String dept_code)
	{
		return repo.findById(dept_code).get();
	}
	@Override
	public departmentMaster Save(departmentMaster departmentmaster)
	{
		return repo.save(departmentmaster);
	}
	@Override
	public List<departmentMaster> SaveAll(List<departmentMaster> departmentmaster)
	{
		return (List<departmentMaster>) repo.saveAll(departmentmaster);
	}
	@Override
	public void delete(String dept_code)
	{
		 repo.deleteById(dept_code);
	}
	@Override
	public  List<Map<String, Object>> getDepartmentList()
	{
		String sSQL="select distinct deptcode, department from department";
		try
		{
			return dao.getDataMap(sSQL);//dao.getJSONData(sSQL);
		}  catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
