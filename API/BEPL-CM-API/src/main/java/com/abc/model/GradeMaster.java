package com.abc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Grademaster")
public class GradeMaster
{
	@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "grade_code")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String grade_code;

	@Column(name = "grade_name")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private String grade_name;

	public String getGrade_code()
	{
		return grade_code;
	}

	public void setGrade_code(String Grade_code)
	{
		this.grade_code = Grade_code;
	}

	public String getGrade_name()
	{
		return grade_name;
	}

	public void setGrade_name(String Grade_name)
	{
		this.grade_name = Grade_name;
	}

}