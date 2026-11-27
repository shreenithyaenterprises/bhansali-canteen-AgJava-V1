package com.abc.model;

import java.sql.Timestamp;
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
@Table(name="emergency")
@IdClass(emergencyId.class)
public class emergency 
{
	@Id
	@Column(name="created_date") 
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+05:30")
	@Temporal(TemporalType.DATE)
	private Date created_date; 
	
	@Id
	@Column(name="shift") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String shift;
	 
	@Column(name="em_controller") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String em_controller;
	 
	@Column(name="em_mobile_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String em_mobile_no;
	 
	@Column(name="assembly_point1") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point1;
	 
	@Column(name="assembly_point1_mobile") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point1_mobile;
	 
	@Column(name="assembly_point2") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point2;
	 
	@Column(name="assembly_point2_mobile") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point2_mobile;
	 
	@Column(name="assembly_point3") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point3;
	 
	@Column(name="assembly_point3_mobile") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String assembly_point3_mobile;
	 
	@Column(name="fire_fighter") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String fire_fighter;
	 
	@Column(name="fire_fighter_mobile") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String fire_fighter_mobile;
	 
	@Column(name="first_aider") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String first_aider;
	 
	@Column(name="first_aider_mobile") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String first_aider_mobile;
	 
	public Date getCreated_date() { 
	  return created_date; 
	} 
//	private void setCreated_date(Date created_date) { 
//	this.created_date= created_date; 
//	}
	public void setCreated_date(Date created_date) { 
	this.created_date= created_date = new Timestamp(System.currentTimeMillis());  
	}	
	public String getShift() { 
	  return shift; 
	} 
	public void setShift(String shift) { 
	this.shift= shift; 
	}
	
	public String getEm_controller() { 
	  return em_controller; 
	} 
	public void setEm_controller(String em_controller) { 
	this.em_controller= em_controller; 
	}
	
	public String getEm_mobile_no() { 
	  return em_mobile_no; 
	} 
	public void setEm_mobile_no(String em_mobile_no) { 
	this.em_mobile_no= em_mobile_no; 
	}
	
	public String getAssembly_point1() { 
	  return assembly_point1; 
	} 
	public void setAssembly_point1(String assembly_point1) { 
	this.assembly_point1= assembly_point1; 
	}
	
	public String getAssembly_point1_mobile() { 
	  return assembly_point1_mobile; 
	} 
	public void setAssembly_point1_mobile(String assembly_point1_mobile) { 
	this.assembly_point1_mobile= assembly_point1_mobile; 
	}
	
	public String getAssembly_point2() { 
	  return assembly_point2; 
	} 
	public void setAssembly_point2(String assembly_point2) { 
	this.assembly_point2= assembly_point2; 
	}
	
	public String getAssembly_point2_mobile() { 
	  return assembly_point2_mobile; 
	} 
	public void setAssembly_point2_mobile(String assembly_point2_mobile) { 
	this.assembly_point2_mobile= assembly_point2_mobile; 
	}
	
	public String getAssembly_point3() { 
	  return assembly_point3; 
	} 
	public void setAssembly_point3(String assembly_point3) { 
	this.assembly_point3= assembly_point3; 
	}
	
	public String getAssembly_point3_mobile() { 
	  return assembly_point3_mobile; 
	} 
	public void setAssembly_point3_mobile(String assembly_point3_mobile) { 
	this.assembly_point3_mobile= assembly_point3_mobile; 
	}
	
	public String getFire_fighter() { 
	  return fire_fighter; 
	} 
	public void setFire_fighter(String fire_fighter) { 
	this.fire_fighter= fire_fighter; 
	}
	
	public String getFire_fighter_mobile() { 
	  return fire_fighter_mobile; 
	} 
	public void setFire_fighter_mobile(String fire_fighter_mobile) { 
	this.fire_fighter_mobile= fire_fighter_mobile; 
	}
	
	public String getFirst_aider() { 
	  return first_aider; 
	} 
	public void setFirst_aider(String first_aider) { 
	this.first_aider= first_aider; 
	}
	
	public String getFirst_aider_mobile() { 
	  return first_aider_mobile; 
	} 
	public void setFirst_aider_mobile(String first_aider_mobile) { 
	this.first_aider_mobile= first_aider_mobile; 
	}

}