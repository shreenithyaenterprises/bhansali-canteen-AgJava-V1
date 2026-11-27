package com.abc.model;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@Table(name="att_regularization")
public class AttRegularization extends AuditModel
{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(generator = "rg_seq")
    @GenericGenerator(name = "rg_seq", strategy = "com.abc.model.CustomNoGenerator")
	@Column(name="req_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String req_no;
	 
	@Column(name="emp_code") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String emp_code;
	 
	@Column(name="emp_name") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String emp_name;
	 
	@Column(name="dept") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String dept;
	 
	@Column(name="from_date") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date from_date; 
	
	@Column(name="to_date") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date to_date; 
	
	@Column(name="in_time") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String in_time;
	 
	@Column(name="out_time") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String out_time;
	 
	@Column(name="status") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String status;
	 
	@Column(name="creation_date") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_date; 

	@Column(name="req_type") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String req_type;
	
	@Column(name="mgr_approver_code") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mgr_approver_code;
	
	@Column(name="mgr_approval") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mgr_approval;
	
	@Column(name="mgr_approval_dt") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mgr_approval_dt;
	
	@Column(name="admin_approval") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String admin_approval;
	
	@Column(name="admin_approval_dt") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date admin_approval_dt;
	
	public String getReq_no() { 
	  return req_no; 
	} 
	public void setReq_no(String req_no) { 
	this.req_no= req_no; 
	}
	
	public String getEmp_code() { 
	  return emp_code; 
	} 
	public void setEmp_code(String emp_code) { 
	this.emp_code= emp_code; 
	}
	
	public String getEmp_name() { 
	  return emp_name; 
	} 
	public void setEmp_name(String emp_name) { 
	this.emp_name= emp_name; 
	}
	
	public String getDept() { 
	  return dept; 
	} 
	public void setDept(String dept) { 
	this.dept= dept; 
	}
	
	public Date getFrom_date() { 
	  return from_date; 
	} 
	public void setFrom_date(Date from_date) { 
	this.from_date= from_date; 
	}
	
	public Date getTo_date() { 
	  return to_date; 
	} 
	public void setTo_date(Date to_date) { 
	this.to_date= to_date; 
	}
	
	public String getIn_time()
	{
		return in_time;
	}
	public void setIn_time(String in_time)
	{
		this.in_time = in_time;
	}
	public String getOut_time()
	{
		return out_time;
	}
	public void setOut_time(String out_time)
	{
		this.out_time = out_time;
	}
	public String getStatus() { 
	  return status; 
	} 
	public void setStatus(String status) { 
	this.status= status; 
	}
	
	public Date getCreation_date() { 
	  return creation_date; 
	} 
	public void setCreation_date(Date creation_date) { 
		this.creation_date= creation_date; 
	}
	
	public String getReq_type()
	{
		return req_type;
	}
	public void setReq_type(String req_type)
	{
		this.req_type = req_type;
	}
	public String getMgr_approver_code()
	{
		return mgr_approver_code;
	}
	public void setMgr_approver_code(String mgr_approver_code)
	{
		this.mgr_approver_code = mgr_approver_code;
	}
	public String getMgr_approval()
	{
		return mgr_approval;
	}
	public void setMgr_approval(String mgr_approval)
	{
		this.mgr_approval = mgr_approval;
	}
	public Date getMgr_approval_dt()
	{
		return mgr_approval_dt;
	}
	public void setMgr_approval_dt(Date mgr_approval_dt)
	{
		this.mgr_approval_dt = mgr_approval_dt;
	}
	public String getAdmin_approval()
	{
		return admin_approval;
	}
	public void setAdmin_approval(String admin_approval)
	{
		this.admin_approval = admin_approval;
	}
	public Date getAdmin_approval_dt()
	{
		return admin_approval_dt;
	}
	public void setAdmin_approval_dt(Date admin_approval_dt)
	{
		this.admin_approval_dt = admin_approval_dt;
	}
	@Override
	public String toString()
	{
		return "AttRegularization [req_no=" + req_no + ", emp_code=" + emp_code + ", emp_name=" + emp_name + ", dept="
				+ dept + ", from_date=" + from_date + ", to_date=" + to_date + ", in_time=" + in_time + ", out_time="
				+ out_time + ", status=" + status + ", creation_date=" + creation_date + ", req_type=" + req_type
				+ ", mgr_approver_code=" + mgr_approver_code + ", mgr_approval=" + mgr_approval + ", mgr_approval_dt="
				+ mgr_approval_dt + ", admin_approval=" + admin_approval + ", admin_approval_dt=" + admin_approval_dt
				+ "]";
	}
}