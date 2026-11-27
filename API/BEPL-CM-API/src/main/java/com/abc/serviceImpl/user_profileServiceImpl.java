package com.abc.serviceImpl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.abc.Startup;
import com.abc.model.EmployeeMaster;
import com.abc.model.user_profile;
import com.abc.repository.EmployeeMasterRepository;
import com.abc.repository.GenericDAO;
import com.abc.repository.user_profileRepository;
import com.abc.service.user_profileService;
import com.abc.utility.AESCrypt;
import com.abc.utility.SMTPUtility;

@Service
@Transactional
public class user_profileServiceImpl implements user_profileService
{

	@Autowired
	user_profileRepository repo;
	
	@Autowired
	EmployeeMasterRepository Emprepo;
	
	@Autowired
	GenericDAO dao;
	
	@Override
	public List<user_profile> getAlluser_profile()
	{
		return (List<user_profile>) repo.findAll();
	}
	@Override
	public user_profile getuser_profileById(String user_id)
	{
		return repo.findById(user_id).get();
	}
	@Override
	public user_profile Save(user_profile user_profile)
	{
		return repo.save(user_profile);
	}
	@Override
	public List<user_profile> SaveAll(List<user_profile> user_profile)
	{
		return (List<user_profile>) repo.saveAll(user_profile);
	}
	@Override
	public void delete(String user_id)
	{
		 repo.deleteById(user_id);
	}
	@Override
	public user_profile getByuserIdAndPassword(String user_id, String password)
	{
		return repo.getUserDetails(user_id, password);
		//repo.findByUseridAndPassword(user_id, password);
	}
	public Map<String, Object> getloginUserDetails(String user_id, String password)
	{
		//String sSQL=" select u.user_id,u.password,u.site,u.role,u.user_name,u.cmpy_code,r.role role_name,r.menu_text "
		//		+ " from user_profile u left join mst_role r on u.role=r.role_id where u.user_id='"+ user_id +"' and u.password='"+password+"'";
		
		String sSQL="select u.user_id,u.password,u.site,u.role,u.user_name,u.password_change,u.cmpy_code,r.role role_name,r.menu_text,e.deptcode,d.department from user_profile u "
		+" left join mst_role r on u.role=r.role_id "
		+" left join employee e on u.user_id=e.empcode "
		+" left join department d on e.deptcode =d.deptcode where u.user_id='"+ user_id +"' and u.password='"+password+"' and r.app_id='CCM'";
		
		return dao.getJSONObject(sSQL);
	}
	@Override
	public String forgotPassword(String user_id)
	{
		String msg="User Id not found! Please contact administrator";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try
		{
			String newPassword =AESCrypt.encrypt(timestamp.toString());
			int i= repo.ResetPassword(user_id, newPassword, 1);
			//user_profile uf =repo.findById(user_id).get();
			EmployeeMaster emp =Emprepo.findById(user_id).get();

			String emailBody=Startup.enviromentProperties.get("emailBodyFP");
			String emailSubject=Startup.enviromentProperties.get("emailSubjectfP");
			emailBody = java.text.MessageFormat.format(emailBody, emp.getEmpname(),newPassword);
			System.out.println(emailBody);
			
			SMTPUtility.sendMail(emp.getEmailid(), null, null,emailBody,emailSubject,null);
			
			if (i> 0)
				msg="Your New password has been sent to your registered email id.";
		} catch (Exception e)
		{
			msg="Password reset Error! Please try later on. ";
		}
		return msg;
	}
	@Override
	public String resetPassword(String user_id, String newPassword)
	{
		String msg="Failed";
		try
		{
			int i= repo.ResetPassword(user_id, newPassword, 0);
			if (i> 0)
				msg="Success";
		} catch (Exception e)
		{
			msg="Error";
		}
		return msg;
	}
}
