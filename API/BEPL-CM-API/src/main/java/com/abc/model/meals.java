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
@Table(name="meals")
public class meals 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="meal_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String meal_code;

@Column(name="meal_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String meal_name;
 
public String getMeal_code() { 
  return meal_code; 
} 
public void setMeal_code(String meal_code) { 
this.meal_code= meal_code; 
}

public String getMeal_name() { 
  return meal_name; 
} 
public void setMeal_name(String meal_name) { 
this.meal_name= meal_name; 
}

}