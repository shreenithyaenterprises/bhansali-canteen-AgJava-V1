package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.abc.bean.role_details;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="user_profile")
public class user_profile //extends role_details
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="user_id") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String userid;

@Column(name="user_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String user_name;

@Column(name="password") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String password;
 
@Column(name="site") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String site;
 
@Column(name="role") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String role;

@Column(name="cmpy_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String cmpy_code;

@Column(name="password_change") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String password_change;
 
public String getUser_id() { 
  return userid; 
} 
public void setUser_id(String user_id) { 
this.userid= user_id; 
}

public String getUser_name()
{
	return user_name;
}
public void setUser_name(String user_name)
{
	this.user_name = user_name;
}
public String getPassword() { 
  return password; 
} 
public void setPassword(String password) { 
this.password= password; 
}

public String getSite() { 
  return site; 
} 
public void setSite(String site) { 
this.site= site; 
}

public String getRole() { 
  return role; 
} 
public void setRole(String role) { 
this.role= role; 
}

public String getCmpy_code()
{
	return cmpy_code;
}
public void setCmpy_code(String cmpy_code)
{
	this.cmpy_code = cmpy_code;
}
public String getPassword_change()
{
	return password_change;
}
public void setPassword_change(String password_change)
{
	this.password_change = password_change;
}

}