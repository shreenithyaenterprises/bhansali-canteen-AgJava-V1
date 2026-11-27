package com.abc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="meals_timing")
@IdClass(Meal_timing_Id.class)
public class meals_timing implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="meal_code")  
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mealCode;
	
	@Column(name="created_date",insertable = false, updatable = false) 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone="GMT+05:30")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date; 
	
	@Column(name="meal_name") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mealName;
	 
	@Column(name="time_range_from") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String time_range_from;
	 
	@Column(name="time_range_to") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String time_range_to;
	 
	@Column(name="site_code") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String siteCode;
	
	@Column(name="emp_contribution")  
	private Double emp_contribution;
	 
	@Column(name="cmpy_contribution") 
	private Double cmpy_contribution;

	@Column(name="cost") 
	private Double cost;

	@Column(name="shift_code") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String shiftCode;
	
	public Date getCreated_date() { 
	  return created_date; 
	} 
	public void setCreated_date(Date created_date) { 
	this.created_date= created_date; 
	}
	
	public String getMealCode() {
		return mealCode;
	}
	public void setMealCode(String mealCode) {
		this.mealCode = mealCode;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public String getTime_range_from() { 
	  return time_range_from; 
	} 
	public void setTime_range_from(String time_range_from) { 
	this.time_range_from= time_range_from; 
	}
	
	public String getTime_range_to() { 
	  return time_range_to; 
	} 
	public void setTime_range_to(String time_range_to) { 
	this.time_range_to= time_range_to; 
	}

	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getShiftCode() {
		return shiftCode;
	}
	public void setShiftCode(String shiftCode) {
		this.shiftCode = shiftCode;
	}
	public Double getEmp_contribution() {
		return emp_contribution;
	}
	public void setEmp_contribution(Double emp_contribution) {
		this.emp_contribution = emp_contribution;
	}
	public Double getCmpy_contribution() {
		return cmpy_contribution;
	}
	public void setCmpy_contribution(Double cmpy_contribution) {
		this.cmpy_contribution = cmpy_contribution;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

}