package com.abc.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="em_contact")
public class EMContact 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sr_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private Integer sr_no;
	
	@Column(name="name") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String name;
	
	@Column(name="assembly_point") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point;
	
	@Column(name="shift") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String shift;
	 
	@Column(name="mobile_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String mobile_no;
	 
	@Column(name="creation_dt", nullable = false, updatable = false) 
	@CreationTimestamp
	private Date creation_dt;

	public Integer getSr_no()
	{
		return sr_no;
	}
	public void setSr_no(Integer sr_no)
	{
		this.sr_no = sr_no;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getAssembly_point()
	{
		return assembly_point;
	}
	public void setAssembly_point(String assembly_point)
	{
		this.assembly_point = assembly_point;
	}
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	public String getMobile_no()
	{
		return mobile_no;
	}

	public void setMobile_no(String mobile_no)
	{
		this.mobile_no = mobile_no;
	}

	public Date getCreation_dt()
	{
		return creation_dt;
	}

	public void setCreation_dt(Date creation_dt)
	{
		this.creation_dt = creation_dt;
	}

	@Override
	public String toString()
	{
		return "EMContact [sr_no=" + sr_no + ", name=" + name + ", assembly_point=" + assembly_point + ", shift="
				+ shift + ", mobile_no=" + mobile_no + ", creation_dt=" + creation_dt + "]";
	} 
}