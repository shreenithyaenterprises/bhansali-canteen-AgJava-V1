package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="contractor")
public class Contractor 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="contcode") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String cont_code;

@Column(name="contname") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String cont_name;
 
@Column(name="incharge_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String incharge;
 
@Column(name="mobile") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String mobile;
 
@Column(name="per_telephone") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String telephone;
 
@Column(name="email") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String email_id;
 
@Column(name="per_country") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String country;
 
@Column(name="per_state") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String state;
 
@Column(name="per_city") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String city;
 
@Column(name="per_pincode") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String pin_code;
 
@Column(name="per_add1") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String add1;
 
@Column(name="per_add2") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String add2;
 
public String getCont_code() { 
  return cont_code; 
} 
public void setCont_code(String cont_code) { 
this.cont_code= cont_code; 
}

public String getCont_name() { 
  return cont_name; 
} 
public void setCont_name(String cont_name) { 
this.cont_name= cont_name; 
}

public String getIncharge() { 
  return incharge; 
} 
public void setIncharge(String incharge) { 
this.incharge= incharge; 
}

public String getMobile() { 
  return mobile; 
} 
public void setMobile(String mobile) { 
this.mobile= mobile; 
}

public String getTelephone() { 
  return telephone; 
} 
public void setTelephone(String telephone) { 
this.telephone= telephone; 
}

public String getEmail_id() { 
  return email_id; 
} 
public void setEmail_id(String email_id) { 
this.email_id= email_id; 
}

public String getCountry() { 
  return country; 
} 
public void setCountry(String country) { 
this.country= country; 
}

public String getState() { 
  return state; 
} 
public void setState(String state) { 
this.state= state; 
}

public String getCity() { 
  return city; 
} 
public void setCity(String city) { 
this.city= city; 
}

public String getPin_code() { 
  return pin_code; 
} 
public void setPin_code(String pin) { 
this.pin_code= pin; 
}

public String getAdd1() { 
  return add1; 
} 
public void setAdd1(String add1) { 
this.add1= add1; 
}

public String getAdd2() { 
  return add2; 
} 
public void setAdd2(String add2) { 
this.add2= add2; 
}

}