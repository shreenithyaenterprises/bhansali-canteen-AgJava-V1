package com.abc.bean;

public class Employee
{
	 private String emp_code;
	 private String emp_name;
	 private String dept;
	 private String shift;

	public String getEmp_code()
	{
		return emp_code;
	}
	public void setEmp_code(String emp_code)
	{
		this.emp_code = emp_code;
	}
	public String getEmp_name()
	{
		return emp_name;
	}
	public void setEmp_name(String emp_name)
	{
		this.emp_name = emp_name;
	}
	public String getDept()
	{
		return dept;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}
	public String getShift()
	{
		return shift;
	}
	public void setShift(String shift)
	{
		this.shift = shift;
	}
	
	@Override
	public String toString()
	{
		return "Employee [emp_code=" + emp_code + ", emp_name=" + emp_name + ", dept=" + dept + ", shift=" + shift
				+ "]";
	}
 
}
