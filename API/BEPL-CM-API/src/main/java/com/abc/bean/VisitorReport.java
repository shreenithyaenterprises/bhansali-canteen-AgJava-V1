package com.abc.bean;

import org.springframework.stereotype.Component;


@Component
public class VisitorReport
{
	 private String status;
	 private String fromdate;
	 private String todate;
 
    public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getFromdate()
	{
		return fromdate;
	}
	public void setFromdate(String fromdate)
	{
		this.fromdate = fromdate;
	}
	public String getTodate()
	{
		return todate;
	}
	public void setTodate(String todate)
	{
		this.todate = todate;
	}
	@Override
	public String toString()
	{
		return "VisitorReport [status=" + status + ", fromdate=" + fromdate + ", todate=" + todate + "]";
	}
	 
}
