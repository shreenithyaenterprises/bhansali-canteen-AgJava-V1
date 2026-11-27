package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="Designationmaster")
public class DesignationMaster 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="designation_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String designation_code;
 
@Column(name="designation_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String designation_name;
 
public String getDesignation_code() { 
  return designation_code; 
} 
public void setDesignation_code(String Designation_code) { 
this.designation_code= Designation_code; 
}

public String getDesignation_name() { 
  return designation_name; 
} 
public void setDesignation_name(String Designation_name) { 
this.designation_name= Designation_name; 
}

}