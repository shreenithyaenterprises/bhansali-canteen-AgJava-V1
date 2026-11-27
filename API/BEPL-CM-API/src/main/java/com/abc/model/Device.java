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

@Entity 
@Table(name="mst_Device")
public class Device 
{
	@Id
	@Column(name="ip_address", updatable=false) 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String ip_address;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="machineno") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String machine_no;
	 
	@Column(name="site_code") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String site_code;
	 
	@Column(name="areacode") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String area_code;
	 
	@Column(name="area_description") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String area_name;
	 
	@Column(name="used_for_ic") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String used_for_ic;
	 
	@Column(name="inout") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String in_out;
	 
	@Column(name="facereader") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String face_reader;
	 
	@Column(name="rfid") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String rf_id;

	@Column(name="machine_sr_no") 
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String machine_sr_no;
	
	public String getIp_address() { 
	  return ip_address; 
	} 
	public void setIp_address(String ip_address) { 
	this.ip_address= ip_address; 
	}
	
	public String getMachine_no() { 
	  return machine_no; 
	} 
	public void setMachine_no(String machine_no) { 
	this.machine_no= machine_no; 
	}
	
	public String getSite_code() {
		return site_code;
	}
	public void setSite_code(String site_code) {
		this.site_code = site_code;
	}
	public String getArea_code() { 
	  return area_code; 
	} 
	public void setArea_code(String area_code) { 
	this.area_code= area_code; 
	}
	public String getArea_name() { 
	  return area_name; 
	} 
	public void setArea_name(String area_name) { 
	this.area_name= area_name; 
	}
	public String getUsed_for_ic() { 
	  return used_for_ic; 
	} 
	public void setUsed_for_ic(String used_for_ic) { 
	this.used_for_ic= used_for_ic; 
	}
	public String getIn_out() { 
	  return in_out; 
	} 
	public void setIn_out(String in_out) { 
	this.in_out= in_out; 
	}
	public String getFace_reader() { 
	  return face_reader; 
	} 
	public void setFace_reader(String face_reader) { 
	this.face_reader= face_reader; 
	}
	public String getRf_id() { 
	  return rf_id; 
	} 
	public void setRf_id(String rf_id) { 
	this.rf_id= rf_id; 
	}
	public String getMachine_sr_no() {
		return machine_sr_no;
	}
	public void setMachine_sr_no(String machine_sr_no) {
		this.machine_sr_no = machine_sr_no;
	}

}