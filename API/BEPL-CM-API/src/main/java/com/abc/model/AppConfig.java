package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "App_Config")
public class AppConfig
{
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "sr_no")
	private int sr_no;

	@Column(name = "variable")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String variable;

	@Column(name = "value")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String value;

	public int getSrNo()
	{
		return sr_no;
	}

	public void setSrNo(int SrNo)
	{
		this.sr_no = SrNo;
	}

	public String getVariable()
	{
		return variable;
	}

	public void setVariable(String variable)
	{
		this.variable = variable;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}