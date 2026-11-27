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
@Table(name="EmailReport")
public class EmailReport 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="rpt_no") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private Integer rpt_no;

@Column(name="rpt_name") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String rpt_name;
 
@Column(name="data_query") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String data_query;
 
@Column(name="email_query") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String email_query;
 
@Column(name="split_column") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String split_column;
 
@Column(name="schedule") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String schedule;
 
@Column(name="subject") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String subject;
 
@Column(name="body") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String body;
 
@Column(name="file_ext") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String file_ext;
 
@Column(name="data_method") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String data_method;
 
@Column(name="status") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String status;
 
public Integer getRpt_no() { 
  return rpt_no; 
} 
public void setRpt_no(Integer rpt_no) { 
this.rpt_no= rpt_no; 
}

public String getRpt_name() { 
  return rpt_name; 
} 
public void setRpt_name(String rpt_name) { 
this.rpt_name= rpt_name; 
}

public String getData_query() { 
  return data_query; 
} 
public void setData_query(String data_query) { 
this.data_query= data_query; 
}

public String getEmail_query() { 
  return email_query; 
} 
public void setEmail_query(String email_query) { 
this.email_query= email_query; 
}

public String getSplit_column() { 
  return split_column; 
} 
public void setSplit_column(String split_column) { 
this.split_column= split_column; 
}

public String getSchedule() { 
  return schedule; 
} 
public void setSchedule(String schedule) { 
this.schedule= schedule; 
}

public String getSubject() { 
  return subject; 
} 
public void setSubject(String subject) { 
this.subject= subject; 
}

public String getBody() { 
  return body; 
} 
public void setBody(String body) { 
this.body= body; 
}

public String getFile_ext() { 
  return file_ext; 
} 
public void setFile_ext(String file_ext) { 
this.file_ext= file_ext; 
}

public String getData_method() { 
  return data_method; 
} 
public void setData_method(String data_method) { 
this.data_method= data_method; 
}

public String getStatus() { 
  return status; 
} 
public void setStatus(String status) { 
this.status= status; 
}

}