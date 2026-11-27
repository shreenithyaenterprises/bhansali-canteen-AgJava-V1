package com.abc.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="email_logs")
public class email_logs 
{

	public email_logs()
	{
			super();
	
	}
	public email_logs(String app_name, String email_to, String email_cc, String email_bcc,
				String email_subject, String email_body, Boolean status, String response)
	{
			super();
			//this.sr_no = sr_no;
			this.app_name = app_name;
			this.email_to = email_to;
			this.email_cc = email_cc;
			this.email_bcc = email_bcc;
			this.email_subject = email_subject;
			this.email_body = email_body;
			this.creation_dt = new Timestamp(System.currentTimeMillis());
			this.status = status;
			this.response = response;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sr_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private Long sr_no;
	
	@Column(name="app_name") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String app_name;
	
	@Column(name="email_to") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_to;
	 
	@Column(name="email_cc") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_cc;
	 
	@Column(name="email_bcc") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_bcc;
	 
	@Column(name="email_subject") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_subject;
	 
	@Column(name="email_body") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String email_body;
	 
	@Column(name="creation_dt") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+05:30")
	private Date creation_dt; 
	
	@Column(name="status") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private Boolean status;
	 
	@Column(name="response") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String response;
	 
	public Long getSr_no()
	{
		return sr_no;
	}
	public void setSr_no(Long sr_no)
	{
		this.sr_no = sr_no;
	}
	public String getApp_name() { 
	  return app_name; 
	} 
	public void setApp_name(String app_name) { 
	this.app_name= app_name; 
	}
	
	public String getEmail_to() { 
	  return email_to; 
	} 
	public void setEmail_to(String email_to) { 
	this.email_to= email_to; 
	}
	
	public String getEmail_cc() { 
	  return email_cc; 
	} 
	public void setEmail_cc(String email_cc) { 
	this.email_cc= email_cc; 
	}
	
	public String getEmail_bcc() { 
	  return email_bcc; 
	} 
	public void setEmail_bcc(String email_bcc) { 
	this.email_bcc= email_bcc; 
	}
	
	public String getEmail_subject() { 
	  return email_subject; 
	} 
	public void setEmail_subject(String email_subject) { 
	this.email_subject= email_subject; 
	}
	
	public String getEmail_body() { 
	  return email_body; 
	} 
	public void setEmail_body(String email_body) { 
	this.email_body= email_body; 
	}
	
	public Date getCreation_dt() { 
	  return creation_dt; 
	} 
	public void setCreation_dt(Date creation_dt) { 
	this.creation_dt= creation_dt; 
	}
	
	public Boolean getStatus() { 
	  return status; 
	} 
	public void setStatus(Boolean status) { 
	this.status= status; 
	}
	
	public String getResponse() { 
	  return response; 
	} 
	public void setResponse(String response) { 
	this.response= response; 
	}

}