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
@Table(name="meals_rate")
public class MealRate 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="sr_no") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private Integer sr_no;

@Column(name="meal_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String meal_code;
 
@Column(name="cat_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String cat_code;
 
@Column(name="rate") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private Double rate;
 
public Integer getSr_no() { 
  return sr_no; 
} 
public void setSr_no(Integer sr_no) { 
this.sr_no= sr_no; 
}

public String getMeal_code() { 
  return meal_code; 
} 
public void setMeal_code(String meal_code) { 
this.meal_code= meal_code; 
}

public String getCat_code() { 
  return cat_code; 
} 
public void setCat_code(String cat_code) { 
this.cat_code= cat_code; 
}

public Double getRate() { 
  return rate; 
} 
public void setRate(Double rate) { 
this.rate= rate; 
}

}