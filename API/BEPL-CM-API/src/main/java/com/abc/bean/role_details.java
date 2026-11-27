package com.abc.bean;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.abc.model.user_profile;


public class role_details extends user_profile
{
	private String role_name;
	private String menu_text;

	public String getRole_name()
	{
		return role_name;
	}
	public void setRole_name(String role_name)
	{
		this.role_name = role_name;
	}
	public String getMenu_text()
	{
		return menu_text;
	}
	public void setMenu_text(String menu_text)
	{
		this.menu_text = menu_text;
	}
	
}
