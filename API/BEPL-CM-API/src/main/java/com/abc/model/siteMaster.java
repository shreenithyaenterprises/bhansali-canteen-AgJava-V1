package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="mst_site")
public class siteMaster 
{
@Id
//@GeneratedValue(strategy=GenerationType.TABLE)
@Column(name="site_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String site_code;
 
@Column(name="site_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String site_name;
 
public String getSite_code() { 
  return site_code; 
} 
public void setSite_code(String site_code) { 
this.site_code= site_code; 
}

public String getSite_name() { 
  return site_name; 
} 
public void setSite_name(String site_name) { 
this.site_name= site_name; 
}

}