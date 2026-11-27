package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "divisionmaster")
public class divisionMaster
{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "division_code")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String division_code;

	@Column(name = "division_name")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String division_name;

	@Column(name = "site_code")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String site_code;

	public String getDivision_code()
	{
		return division_code;
	}

	public void setDivision_code(String division_code)
	{
		this.division_code = division_code;
	}

	public String getDivision_name()
	{
		return division_name;
	}

	public void setDivision_name(String division_name)
	{
		this.division_name = division_name;
	}

	public String getSite_code()
	{
		return site_code;
	}

	public void setSite_code(String site_code)
	{
		this.site_code = site_code;
	}

}