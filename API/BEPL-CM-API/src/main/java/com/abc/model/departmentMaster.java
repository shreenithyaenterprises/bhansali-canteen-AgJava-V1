package com.abc.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
@Table(name="department")
public class departmentMaster 
{
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="deptcode") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String dept_code;
 
@Column(name="department") 
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
private String dept_name;

@Column(name="created_date", nullable = false, updatable = false) 
@CreationTimestamp
private Date creation_date;

@Column(name="modified_date", nullable = false, insertable = false) 
@CreationTimestamp
private Date modified_date;

public String getDept_code()
{
	return dept_code;
}

public void setDept_code(String dept_code)
{
	this.dept_code = dept_code;
}

public String getDept_name()
{
	return dept_name;
}

public void setDept_name(String dept_name)
{
	this.dept_name = dept_name;
}

public Date getCreation_date()
{
	return creation_date;
}

public void setCreation_date(Date creation_date)
{
	this.creation_date = creation_date;
}

public Date getModified_date()
{
	return modified_date;
}

public void setModified_date(Date modified_date)
{
	this.modified_date = modified_date;
}




}