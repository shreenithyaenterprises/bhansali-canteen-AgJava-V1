package com.abc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Employee")
public class EmployeeMaster
{
	@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "empcode")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String empcode;

	@Column(name = "enrolment_number")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String enrollment_number;
//	@Column(name = "title")
//	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
//	private String title;

	@Column(name = "name")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String empname;

	@Column(name = "gender")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String gender;

	@Column(name = "dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30", with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name = "doj")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30", with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;

	@Column(name = "dol")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+05:30", with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dol;

	@Column(name = "mobile")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mobile;

	@Column(name = "email")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String emailid;

	@Column(name = "site")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String site;

	@Column(name = "establishment")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String establishment;

	@Column(name = "division")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String division;

	@Column(name = "deptcode")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String department;

	@Column(name = "catcode")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String category;

	@Column(name = "desgcode")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String designation;

	@Column(name = "grade")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String grade;
	
	@Column(name = "contcode")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String contractor;

	@Column(name="leftYN") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String left;
	
	@Column(name="left_date") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+05:30")
	private Date left_date;
	public String getEmpcode()
	{
		return empcode;
	}

	public void setEmpcode(String empcode)
	{
		this.empcode = empcode;
	}

	public String getEnrollment_number()
	{
		return enrollment_number;
	}

	public void setEnrollment_number(String enrollment_number)
	{
		this.enrollment_number = enrollment_number;
	}

	public String getEmpname()
	{
		return empname;
	}

	public void setEmpname(String empname)
	{
		this.empname = empname;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public Date getDoj()
	{
		return doj;
	}

	public void setDoj(Date doj)
	{
		this.doj = doj;
	}

	public Date getDol()
	{
		return dol;
	}

	public void setDol(Date dol)
	{
		this.dol = dol;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getEmailid()
	{
		return emailid;
	}

	public void setEmailid(String emailid)
	{
		this.emailid = emailid;
	}

	public String getSite()
	{
		return site;
	}

	public void setSite(String site)
	{
		this.site = site;
	}

	public String getEstablishment()
	{
		return establishment;
	}

	public void setEstablishment(String establishment)
	{
		this.establishment = establishment;
	}

	public String getDivision()
	{
		return division;
	}

	public void setDivision(String division)
	{
		this.division = division;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public Date getLeft_date() {
		return left_date;
	}

	public void setLeft_date(Date left_date) {
		this.left_date = left_date;
	}

}