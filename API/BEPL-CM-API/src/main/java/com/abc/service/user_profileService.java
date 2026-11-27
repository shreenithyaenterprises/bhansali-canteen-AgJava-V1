package com.abc.service;

import java.util.List;
import java.util.Map;

import com.abc.model.user_profile;

public interface user_profileService
{

	public List<user_profile> getAlluser_profile();
	
	public user_profile getuser_profileById(String user_id);
	
	public user_profile getByuserIdAndPassword(String user_id, String password);
	
	public user_profile Save(user_profile user_profile);
	
	public List<user_profile> SaveAll(List<user_profile> user_profile);
	
	public void delete(String user_id);
	
	public  Map<String, Object> getloginUserDetails(String user_id, String password);
	
	public String forgotPassword(String user_id);
	
	public String resetPassword(String user_id, String password);

}