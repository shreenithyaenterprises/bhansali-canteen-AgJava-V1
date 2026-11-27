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
@Table(name="Category")
public class CategoryMaster 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="catcode") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String category_code;
 
@Column(name="category") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String category_name;
 
public String getCategory_code() { 
  return category_code; 
} 
public void setCategory_code(String Category_code) { 
this.category_code= Category_code; 
}

public String getCategory_name() { 
  return category_name; 
} 
public void setCategory_name(String Category_name) { 
this.category_name= Category_name; 
}

}