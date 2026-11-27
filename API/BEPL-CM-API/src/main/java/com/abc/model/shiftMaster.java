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
@Table(name="shiftMaster")
public class shiftMaster 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="shift_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String shift_code;
 
@Column(name="shift_type") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String shift_type;
 
@Column(name="in_time") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String in_time;
 
@Column(name="out_time") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String out_time;
 
@Column(name="lunch_in") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String lunch_in;
 
@Column(name="lunch_out") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String lunch_out;
 
@Column(name="shift_range_from") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String shift_range_from;
 
@Column(name="shift_range_to") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String shift_range_to;
 
@Column(name="site_code") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String site_code;
 
@Column(name="site_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String site_name;
 
public String getShift_code() { 
  return shift_code; 
} 
public void setShift_code(String shift_code) { 
this.shift_code= shift_code; 
}

public String getShift_type() { 
  return shift_type; 
} 
public void setShift_type(String shift_type) { 
this.shift_type= shift_type; 
}

public String getIn_time() { 
  return in_time; 
} 
public void setIn_time(String in_time) { 
this.in_time= in_time; 
}

public String getOut_time() { 
  return out_time; 
} 
public void setOut_time(String out_time) { 
this.out_time= out_time; 
}

public String getLunch_in() { 
  return lunch_in; 
} 
public void setLunch_in(String lunch_in) { 
this.lunch_in= lunch_in; 
}

public String getLunch_out() { 
  return lunch_out; 
} 
public void setLunch_out(String lunch_out) { 
this.lunch_out= lunch_out; 
}

public String getShift_range_from() { 
  return shift_range_from; 
} 
public void setShift_range_from(String shift_range_from) { 
this.shift_range_from= shift_range_from; 
}

public String getShift_range_to() { 
  return shift_range_to; 
} 
public void setShift_range_to(String shift_range_to) { 
this.shift_range_to= shift_range_to; 
}

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